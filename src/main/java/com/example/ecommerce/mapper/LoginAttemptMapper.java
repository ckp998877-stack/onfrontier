package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.LoginAttemptDto;
import com.example.ecommerce.entity.LoginAttempt;
import org.springframework.stereotype.Component;

@Component
public class LoginAttemptMapper {
    public LoginAttemptDto toDto(LoginAttempt entity) {
        LoginAttemptDto dto = new LoginAttemptDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public LoginAttempt toEntity(LoginAttemptDto dto) {
        LoginAttempt entity = new LoginAttempt();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
