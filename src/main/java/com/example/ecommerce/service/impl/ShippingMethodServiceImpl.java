package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ShippingMethodDto;
import com.example.ecommerce.entity.ShippingMethod;
import com.example.ecommerce.repository.ShippingMethodRepository;
import com.example.ecommerce.service.ShippingMethodService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingMethodServiceImpl implements ShippingMethodService {
    private final ShippingMethodRepository repository;

    public ShippingMethodServiceImpl(ShippingMethodRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShippingMethodDto create(ShippingMethodDto dto) {
        ShippingMethod entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ShippingMethodDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ShippingMethod not found: " + id));
    }

    @Override
    public List<ShippingMethodDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ShippingMethodDto update(Long id, ShippingMethodDto dto) {
        ShippingMethod entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ShippingMethod not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ShippingMethod toEntity(ShippingMethodDto dto) {
        ShippingMethod e = new ShippingMethod();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ShippingMethodDto toDto(ShippingMethod e) {
        ShippingMethodDto d = new ShippingMethodDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
