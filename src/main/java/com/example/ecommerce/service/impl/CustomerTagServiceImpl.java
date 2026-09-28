package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CustomerTagDto;
import com.example.ecommerce.entity.CustomerTag;
import com.example.ecommerce.repository.CustomerTagRepository;
import com.example.ecommerce.service.CustomerTagService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerTagServiceImpl implements CustomerTagService {
    private final CustomerTagRepository repository;

    public CustomerTagServiceImpl(CustomerTagRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerTagDto create(CustomerTagDto dto) {
        CustomerTag entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CustomerTagDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("CustomerTag not found: " + id));
    }

    @Override
    public List<CustomerTagDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerTagDto update(Long id, CustomerTagDto dto) {
        CustomerTag entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CustomerTag not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CustomerTag toEntity(CustomerTagDto dto) {
        CustomerTag e = new CustomerTag();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CustomerTagDto toDto(CustomerTag e) {
        CustomerTagDto d = new CustomerTagDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
