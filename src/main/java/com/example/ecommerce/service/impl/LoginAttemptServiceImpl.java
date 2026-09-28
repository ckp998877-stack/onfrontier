package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.LoginAttemptDto;
import com.example.ecommerce.entity.LoginAttempt;
import com.example.ecommerce.repository.LoginAttemptRepository;
import com.example.ecommerce.service.LoginAttemptService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginAttemptServiceImpl implements LoginAttemptService {
    private final LoginAttemptRepository repository;

    public LoginAttemptServiceImpl(LoginAttemptRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoginAttemptDto create(LoginAttemptDto dto) {
        LoginAttempt entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public LoginAttemptDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("LoginAttempt not found: " + id));
    }

    @Override
    public List<LoginAttemptDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public LoginAttemptDto update(Long id, LoginAttemptDto dto) {
        LoginAttempt entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("LoginAttempt not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private LoginAttempt toEntity(LoginAttemptDto dto) {
        LoginAttempt e = new LoginAttempt();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private LoginAttemptDto toDto(LoginAttempt e) {
        LoginAttemptDto d = new LoginAttemptDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
