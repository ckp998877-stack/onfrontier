package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ShipmentDto;
import com.example.ecommerce.entity.Shipment;
import com.example.ecommerce.repository.ShipmentRepository;
import com.example.ecommerce.service.ShipmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository repository;

    public ShipmentServiceImpl(ShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShipmentDto create(ShipmentDto dto) {
        Shipment entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ShipmentDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found: " + id));
    }

    @Override
    public List<ShipmentDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ShipmentDto update(Long id, ShipmentDto dto) {
        Shipment entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Shipment toEntity(ShipmentDto dto) {
        Shipment e = new Shipment();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ShipmentDto toDto(Shipment e) {
        ShipmentDto d = new ShipmentDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
