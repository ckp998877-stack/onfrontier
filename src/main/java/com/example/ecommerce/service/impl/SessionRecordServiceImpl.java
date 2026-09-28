package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SessionRecordDto;
import com.example.ecommerce.entity.SessionRecord;
import com.example.ecommerce.repository.SessionRecordRepository;
import com.example.ecommerce.service.SessionRecordService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionRecordServiceImpl implements SessionRecordService {
    private final SessionRecordRepository repository;

    public SessionRecordServiceImpl(SessionRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public SessionRecordDto create(SessionRecordDto dto) {
        SessionRecord entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SessionRecordDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SessionRecord not found: " + id));
    }

    @Override
    public List<SessionRecordDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SessionRecordDto update(Long id, SessionRecordDto dto) {
        SessionRecord entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SessionRecord not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SessionRecord toEntity(SessionRecordDto dto) {
        SessionRecord e = new SessionRecord();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SessionRecordDto toDto(SessionRecord e) {
        SessionRecordDto d = new SessionRecordDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
