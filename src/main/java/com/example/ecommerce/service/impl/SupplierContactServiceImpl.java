package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SupplierContactDto;
import com.example.ecommerce.entity.SupplierContact;
import com.example.ecommerce.repository.SupplierContactRepository;
import com.example.ecommerce.service.SupplierContactService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierContactServiceImpl implements SupplierContactService {
    private final SupplierContactRepository repository;

    public SupplierContactServiceImpl(SupplierContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierContactDto create(SupplierContactDto dto) {
        SupplierContact entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SupplierContactDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SupplierContact not found: " + id));
    }

    @Override
    public List<SupplierContactDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SupplierContactDto update(Long id, SupplierContactDto dto) {
        SupplierContact entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SupplierContact not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SupplierContact toEntity(SupplierContactDto dto) {
        SupplierContact e = new SupplierContact();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SupplierContactDto toDto(SupplierContact e) {
        SupplierContactDto d = new SupplierContactDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
