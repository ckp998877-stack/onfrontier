package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ApiLogDto;
import com.example.ecommerce.entity.ApiLog;
import com.example.ecommerce.repository.ApiLogRepository;
import com.example.ecommerce.service.ApiLogService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiLogServiceImpl implements ApiLogService {
    private final ApiLogRepository repository;

    public ApiLogServiceImpl(ApiLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApiLogDto create(ApiLogDto dto) {
        ApiLog entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ApiLogDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ApiLog not found: " + id));
    }

    @Override
    public List<ApiLogDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ApiLogDto update(Long id, ApiLogDto dto) {
        ApiLog entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ApiLog not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ApiLog toEntity(ApiLogDto dto) {
        ApiLog e = new ApiLog();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ApiLogDto toDto(ApiLog e) {
        ApiLogDto d = new ApiLogDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
