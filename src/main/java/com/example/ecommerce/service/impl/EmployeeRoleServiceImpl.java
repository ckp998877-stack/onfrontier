package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.EmployeeRoleDto;
import com.example.ecommerce.entity.EmployeeRole;
import com.example.ecommerce.repository.EmployeeRoleRepository;
import com.example.ecommerce.service.EmployeeRoleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    private final EmployeeRoleRepository repository;

    public EmployeeRoleServiceImpl(EmployeeRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeRoleDto create(EmployeeRoleDto dto) {
        EmployeeRole entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public EmployeeRoleDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("EmployeeRole not found: " + id));
    }

    @Override
    public List<EmployeeRoleDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeRoleDto update(Long id, EmployeeRoleDto dto) {
        EmployeeRole entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("EmployeeRole not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private EmployeeRole toEntity(EmployeeRoleDto dto) {
        EmployeeRole e = new EmployeeRole();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private EmployeeRoleDto toDto(EmployeeRole e) {
        EmployeeRoleDto d = new EmployeeRoleDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
