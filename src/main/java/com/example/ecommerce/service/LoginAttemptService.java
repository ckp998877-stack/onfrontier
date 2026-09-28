package com.example.ecommerce.service;

import com.example.ecommerce.dto.LoginAttemptDto;
import java.util.List;

public interface LoginAttemptService {
    LoginAttemptDto create(LoginAttemptDto dto);
    LoginAttemptDto getById(Long id);
    List<LoginAttemptDto> getAll();
    LoginAttemptDto update(Long id, LoginAttemptDto dto);
    void delete(Long id);
}
