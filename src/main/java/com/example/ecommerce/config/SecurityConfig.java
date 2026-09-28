package com.example.ecommerce.config;

import com.example.ecommerce.security.RestAccessDeniedHandler;
import com.example.ecommerce.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Basic Spring Security setup for the REST API.
 *
 * <p>Every {@code /api/**} endpoint requires an authenticated user via HTTP
 * Basic. The H2 console is restricted to the {@code ADMIN} role. Credentials
 * are supplied through {@code application.properties} so they can be changed
 * per environment without a recompile.
 *
 * <p>Uses the {@link SecurityFilterChain} bean style;
 * {@code WebSecurityConfigurerAdapter} is deprecated as of Spring Security 5.7.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final RestAuthenticationEntryPoint authenticationEntryPoint;
    private final RestAccessDeniedHandler accessDeniedHandler;

    @Value("${app.security.user.username}")
    private String userUsername;

    @Value("${app.security.user.password}")
    private String userPassword;

    @Value("${app.security.admin.username}")
    private String adminUsername;

    @Value("${app.security.admin.password}")
    private String adminPassword;

    public SecurityConfig(RestAuthenticationEntryPoint authenticationEntryPoint,
                          RestAccessDeniedHandler accessDeniedHandler) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername(userUsername)
                .password(passwordEncoder.encode(userPassword))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername(adminUsername)
                .password(passwordEncoder.encode(adminPassword))
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Stateless REST clients send credentials on every call, so there
                // is no session-bound CSRF token to validate.
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    // Health/error plumbing stays reachable so container probes
                    // and Boot's error dispatch keep working as before.
                    .antMatchers("/error").permitAll()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .antMatchers("/h2-console/**").hasRole("ADMIN")
                    .antMatchers("/api/**").authenticated()
                    .anyRequest().authenticated()
                    .and()
                .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                    .accessDeniedHandler(accessDeniedHandler)
                    .and()
                // The entry point is set on httpBasic() as well, otherwise its
                // own BasicAuthenticationEntryPoint handles bad credentials and
                // returns Boot's default error body instead of ErrorResponse.
                .httpBasic()
                    .authenticationEntryPoint(authenticationEntryPoint);

        // The H2 console renders inside frames, which the default
        // X-Frame-Options: DENY header would otherwise block.
        http.headers().frameOptions().sameOrigin();

        return http.build();
    }
}
