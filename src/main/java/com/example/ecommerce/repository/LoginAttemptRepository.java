package com.example.ecommerce.repository;

import com.example.ecommerce.entity.LoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long> {
    LoginAttempt findFirstByCode(String code);
}
