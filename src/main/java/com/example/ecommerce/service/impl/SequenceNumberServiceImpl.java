package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SequenceNumberDto;
import com.example.ecommerce.entity.SequenceNumber;
import com.example.ecommerce.repository.SequenceNumberRepository;
import com.example.ecommerce.service.SequenceNumberService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SequenceNumberServiceImpl implements SequenceNumberService {
    private final SequenceNumberRepository repository;

    public SequenceNumberServiceImpl(SequenceNumberRepository repository) {
        this.repository = repository;
    }

    @Override
    public SequenceNumberDto create(SequenceNumberDto dto) {
        SequenceNumber entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SequenceNumberDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SequenceNumber not found: " + id));
    }

    @Override
    public List<SequenceNumberDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SequenceNumberDto update(Long id, SequenceNumberDto dto) {
        SequenceNumber entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SequenceNumber not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SequenceNumber toEntity(SequenceNumberDto dto) {
        SequenceNumber e = new SequenceNumber();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SequenceNumberDto toDto(SequenceNumber e) {
        SequenceNumberDto d = new SequenceNumberDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
