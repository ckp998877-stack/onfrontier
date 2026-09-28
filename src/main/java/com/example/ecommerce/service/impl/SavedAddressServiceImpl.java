package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SavedAddressDto;
import com.example.ecommerce.entity.SavedAddress;
import com.example.ecommerce.repository.SavedAddressRepository;
import com.example.ecommerce.service.SavedAddressService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavedAddressServiceImpl implements SavedAddressService {
    private final SavedAddressRepository repository;

    public SavedAddressServiceImpl(SavedAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public SavedAddressDto create(SavedAddressDto dto) {
        SavedAddress entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SavedAddressDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SavedAddress not found: " + id));
    }

    @Override
    public List<SavedAddressDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SavedAddressDto update(Long id, SavedAddressDto dto) {
        SavedAddress entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SavedAddress not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SavedAddress toEntity(SavedAddressDto dto) {
        SavedAddress e = new SavedAddress();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SavedAddressDto toDto(SavedAddress e) {
        SavedAddressDto d = new SavedAddressDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
