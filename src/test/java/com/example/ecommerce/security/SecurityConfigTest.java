package com.example.ecommerce.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void apiRequiresAuthentication() throws Exception {
        mockMvc.perform(get("/api/accounts"))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(401))
                .andExpect(jsonPath("$.message").value("Authentication required"));
    }

    @Test
    void apiRejectsBadCredentials() throws Exception {
        mockMvc.perform(get("/api/accounts").with(httpBasic("user", "wrong-password")))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(401));
    }

    @Test
    void apiAllowsAuthenticatedUser() throws Exception {
        mockMvc.perform(get("/api/accounts").with(httpBasic("user", "user123")))
                .andExpect(status().isOk());
    }

    @Test
    void h2ConsoleIsForbiddenForNonAdmin() throws Exception {
        mockMvc.perform(get("/h2-console").with(httpBasic("user", "user123")))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.status").value(403));
    }

    /**
     * The console servlet is not registered in MockMvc's mock environment, so
     * the request 404s here rather than redirecting. What matters is that ADMIN
     * clears the authorization filter instead of being rejected with 401/403.
     */
    @Test
    void h2ConsoleIsAuthorizedForAdmin() throws Exception {
        int status = mockMvc.perform(get("/h2-console").with(httpBasic("admin", "admin123")))
                .andReturn().getResponse().getStatus();

        org.junit.jupiter.api.Assertions.assertTrue(status != 401 && status != 403,
                "ADMIN should pass authorization for the H2 console, but got " + status);
    }
}
