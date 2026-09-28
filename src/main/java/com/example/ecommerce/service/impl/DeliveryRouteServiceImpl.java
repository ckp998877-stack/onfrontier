package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.DeliveryRouteDto;
import com.example.ecommerce.entity.DeliveryRoute;
import com.example.ecommerce.repository.DeliveryRouteRepository;
import com.example.ecommerce.service.DeliveryRouteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryRouteServiceImpl implements DeliveryRouteService {
    private final DeliveryRouteRepository repository;

    public DeliveryRouteServiceImpl(DeliveryRouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryRouteDto create(DeliveryRouteDto dto) {
        DeliveryRoute entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public DeliveryRouteDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("DeliveryRoute not found: " + id));
    }

    @Override
    public List<DeliveryRouteDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DeliveryRouteDto update(Long id, DeliveryRouteDto dto) {
        DeliveryRoute entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DeliveryRoute not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DeliveryRoute toEntity(DeliveryRouteDto dto) {
        DeliveryRoute e = new DeliveryRoute();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private DeliveryRouteDto toDto(DeliveryRoute e) {
        DeliveryRouteDto d = new DeliveryRouteDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
