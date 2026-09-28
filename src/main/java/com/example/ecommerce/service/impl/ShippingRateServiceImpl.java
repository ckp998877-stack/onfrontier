package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ShippingRateDto;
import com.example.ecommerce.entity.ShippingRate;
import com.example.ecommerce.repository.ShippingRateRepository;
import com.example.ecommerce.service.ShippingRateService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingRateServiceImpl implements ShippingRateService {
    private final ShippingRateRepository repository;

    public ShippingRateServiceImpl(ShippingRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShippingRateDto create(ShippingRateDto dto) {
        ShippingRate entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ShippingRateDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ShippingRate not found: " + id));
    }

    @Override
    public List<ShippingRateDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ShippingRateDto update(Long id, ShippingRateDto dto) {
        ShippingRate entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ShippingRate not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ShippingRate toEntity(ShippingRateDto dto) {
        ShippingRate e = new ShippingRate();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ShippingRateDto toDto(ShippingRate e) {
        ShippingRateDto d = new ShippingRateDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
