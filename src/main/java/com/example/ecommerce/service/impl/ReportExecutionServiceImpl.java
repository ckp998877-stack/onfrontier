package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ReportExecutionDto;
import com.example.ecommerce.entity.ReportExecution;
import com.example.ecommerce.repository.ReportExecutionRepository;
import com.example.ecommerce.service.ReportExecutionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportExecutionServiceImpl implements ReportExecutionService {
    private final ReportExecutionRepository repository;

    public ReportExecutionServiceImpl(ReportExecutionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReportExecutionDto create(ReportExecutionDto dto) {
        ReportExecution entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ReportExecutionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ReportExecution not found: " + id));
    }

    @Override
    public List<ReportExecutionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReportExecutionDto update(Long id, ReportExecutionDto dto) {
        ReportExecution entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ReportExecution not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ReportExecution toEntity(ReportExecutionDto dto) {
        ReportExecution e = new ReportExecution();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ReportExecutionDto toDto(ReportExecution e) {
        ReportExecutionDto d = new ReportExecutionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
