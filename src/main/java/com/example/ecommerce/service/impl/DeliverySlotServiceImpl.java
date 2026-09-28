package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.DeliverySlotDto;
import com.example.ecommerce.entity.DeliverySlot;
import com.example.ecommerce.repository.DeliverySlotRepository;
import com.example.ecommerce.service.DeliverySlotService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliverySlotServiceImpl implements DeliverySlotService {
    private final DeliverySlotRepository repository;

    public DeliverySlotServiceImpl(DeliverySlotRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliverySlotDto create(DeliverySlotDto dto) {
        DeliverySlot entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public DeliverySlotDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("DeliverySlot not found: " + id));
    }

    @Override
    public List<DeliverySlotDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DeliverySlotDto update(Long id, DeliverySlotDto dto) {
        DeliverySlot entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DeliverySlot not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DeliverySlot toEntity(DeliverySlotDto dto) {
        DeliverySlot e = new DeliverySlot();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private DeliverySlotDto toDto(DeliverySlot e) {
        DeliverySlotDto d = new DeliverySlotDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
