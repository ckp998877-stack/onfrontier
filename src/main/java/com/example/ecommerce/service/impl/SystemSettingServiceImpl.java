package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SystemSettingDto;
import com.example.ecommerce.entity.SystemSetting;
import com.example.ecommerce.repository.SystemSettingRepository;
import com.example.ecommerce.service.SystemSettingService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemSettingServiceImpl implements SystemSettingService {
    private final SystemSettingRepository repository;

    public SystemSettingServiceImpl(SystemSettingRepository repository) {
        this.repository = repository;
    }

    @Override
    public SystemSettingDto create(SystemSettingDto dto) {
        SystemSetting entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SystemSettingDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SystemSetting not found: " + id));
    }

    @Override
    public List<SystemSettingDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SystemSettingDto update(Long id, SystemSettingDto dto) {
        SystemSetting entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SystemSetting not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SystemSetting toEntity(SystemSettingDto dto) {
        SystemSetting e = new SystemSetting();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SystemSettingDto toDto(SystemSetting e) {
        SystemSettingDto d = new SystemSettingDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
