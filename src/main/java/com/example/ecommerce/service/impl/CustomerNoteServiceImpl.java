package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CustomerNoteDto;
import com.example.ecommerce.entity.CustomerNote;
import com.example.ecommerce.repository.CustomerNoteRepository;
import com.example.ecommerce.service.CustomerNoteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerNoteServiceImpl implements CustomerNoteService {
    private final CustomerNoteRepository repository;

    public CustomerNoteServiceImpl(CustomerNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerNoteDto create(CustomerNoteDto dto) {
        CustomerNote entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CustomerNoteDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("CustomerNote not found: " + id));
    }

    @Override
    public List<CustomerNoteDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerNoteDto update(Long id, CustomerNoteDto dto) {
        CustomerNote entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CustomerNote not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CustomerNote toEntity(CustomerNoteDto dto) {
        CustomerNote e = new CustomerNote();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CustomerNoteDto toDto(CustomerNote e) {
        CustomerNoteDto d = new CustomerNoteDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
