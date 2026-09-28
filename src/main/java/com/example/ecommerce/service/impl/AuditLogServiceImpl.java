package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.AuditLogDto;
import com.example.ecommerce.entity.AuditLog;
import com.example.ecommerce.repository.AuditLogRepository;
import com.example.ecommerce.service.AuditLogService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    private final AuditLogRepository repository;

    public AuditLogServiceImpl(AuditLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditLogDto create(AuditLogDto dto) {
        AuditLog entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public AuditLogDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("AuditLog not found: " + id));
    }

    @Override
    public List<AuditLogDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public AuditLogDto update(Long id, AuditLogDto dto) {
        AuditLog entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("AuditLog not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private AuditLog toEntity(AuditLogDto dto) {
        AuditLog e = new AuditLog();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private AuditLogDto toDto(AuditLog e) {
        AuditLogDto d = new AuditLogDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
