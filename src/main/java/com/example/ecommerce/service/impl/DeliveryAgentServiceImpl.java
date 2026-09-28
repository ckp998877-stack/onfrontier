package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.DeliveryAgentDto;
import com.example.ecommerce.entity.DeliveryAgent;
import com.example.ecommerce.repository.DeliveryAgentRepository;
import com.example.ecommerce.service.DeliveryAgentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {
    private final DeliveryAgentRepository repository;

    public DeliveryAgentServiceImpl(DeliveryAgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryAgentDto create(DeliveryAgentDto dto) {
        DeliveryAgent entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public DeliveryAgentDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("DeliveryAgent not found: " + id));
    }

    @Override
    public List<DeliveryAgentDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DeliveryAgentDto update(Long id, DeliveryAgentDto dto) {
        DeliveryAgent entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DeliveryAgent not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DeliveryAgent toEntity(DeliveryAgentDto dto) {
        DeliveryAgent e = new DeliveryAgent();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private DeliveryAgentDto toDto(DeliveryAgent e) {
        DeliveryAgentDto d = new DeliveryAgentDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
