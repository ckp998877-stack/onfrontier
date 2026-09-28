package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.EmployeeDto;
import com.example.ecommerce.entity.Employee;
import com.example.ecommerce.repository.EmployeeRepository;
import com.example.ecommerce.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeDto create(EmployeeDto dto) {
        Employee entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public EmployeeDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found: " + id));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto dto) {
        Employee entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Employee toEntity(EmployeeDto dto) {
        Employee e = new Employee();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private EmployeeDto toDto(Employee e) {
        EmployeeDto d = new EmployeeDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
