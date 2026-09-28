package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.DepartmentDto;
import com.example.ecommerce.entity.Department;
import com.example.ecommerce.repository.DepartmentRepository;
import com.example.ecommerce.service.DepartmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentDto create(DepartmentDto dto) {
        Department entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public DepartmentDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Department not found: " + id));
    }

    @Override
    public List<DepartmentDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto update(Long id, DepartmentDto dto) {
        Department entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Department toEntity(DepartmentDto dto) {
        Department e = new Department();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private DepartmentDto toDto(Department e) {
        DepartmentDto d = new DepartmentDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
