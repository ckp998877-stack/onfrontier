package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.DeliveryDto;
import com.example.ecommerce.entity.Delivery;
import com.example.ecommerce.repository.DeliveryRepository;
import com.example.ecommerce.service.DeliveryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository repository;

    public DeliveryServiceImpl(DeliveryRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryDto create(DeliveryDto dto) {
        Delivery entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public DeliveryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Delivery not found: " + id));
    }

    @Override
    public List<DeliveryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DeliveryDto update(Long id, DeliveryDto dto) {
        Delivery entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Delivery not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Delivery toEntity(DeliveryDto dto) {
        Delivery e = new Delivery();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private DeliveryDto toDto(Delivery e) {
        DeliveryDto d = new DeliveryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
