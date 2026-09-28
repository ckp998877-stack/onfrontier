package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CustomerGroupDto;
import com.example.ecommerce.entity.CustomerGroup;
import com.example.ecommerce.repository.CustomerGroupRepository;
import com.example.ecommerce.service.CustomerGroupService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerGroupServiceImpl implements CustomerGroupService {
    private final CustomerGroupRepository repository;

    public CustomerGroupServiceImpl(CustomerGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerGroupDto create(CustomerGroupDto dto) {
        CustomerGroup entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CustomerGroupDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("CustomerGroup not found: " + id));
    }

    @Override
    public List<CustomerGroupDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerGroupDto update(Long id, CustomerGroupDto dto) {
        CustomerGroup entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CustomerGroup not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CustomerGroup toEntity(CustomerGroupDto dto) {
        CustomerGroup e = new CustomerGroup();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CustomerGroupDto toDto(CustomerGroup e) {
        CustomerGroupDto d = new CustomerGroupDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
