package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.AddressDto;
import com.example.ecommerce.entity.Address;
import com.example.ecommerce.repository.AddressRepository;
import com.example.ecommerce.service.AddressService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public AddressDto create(AddressDto dto) {
        Address entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public AddressDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Address not found: " + id));
    }

    @Override
    public List<AddressDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public AddressDto update(Long id, AddressDto dto) {
        Address entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Address toEntity(AddressDto dto) {
        Address e = new Address();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private AddressDto toDto(Address e) {
        AddressDto d = new AddressDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
