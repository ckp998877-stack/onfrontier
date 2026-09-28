package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.EmployeePermissionDto;
import com.example.ecommerce.entity.EmployeePermission;
import com.example.ecommerce.repository.EmployeePermissionRepository;
import com.example.ecommerce.service.EmployeePermissionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePermissionServiceImpl implements EmployeePermissionService {
    private final EmployeePermissionRepository repository;

    public EmployeePermissionServiceImpl(EmployeePermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeePermissionDto create(EmployeePermissionDto dto) {
        EmployeePermission entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public EmployeePermissionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("EmployeePermission not found: " + id));
    }

    @Override
    public List<EmployeePermissionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeePermissionDto update(Long id, EmployeePermissionDto dto) {
        EmployeePermission entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("EmployeePermission not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private EmployeePermission toEntity(EmployeePermissionDto dto) {
        EmployeePermission e = new EmployeePermission();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private EmployeePermissionDto toDto(EmployeePermission e) {
        EmployeePermissionDto d = new EmployeePermissionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
