package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ReportDefinitionDto;
import com.example.ecommerce.entity.ReportDefinition;
import com.example.ecommerce.repository.ReportDefinitionRepository;
import com.example.ecommerce.service.ReportDefinitionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportDefinitionServiceImpl implements ReportDefinitionService {
    private final ReportDefinitionRepository repository;

    public ReportDefinitionServiceImpl(ReportDefinitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReportDefinitionDto create(ReportDefinitionDto dto) {
        ReportDefinition entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ReportDefinitionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ReportDefinition not found: " + id));
    }

    @Override
    public List<ReportDefinitionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReportDefinitionDto update(Long id, ReportDefinitionDto dto) {
        ReportDefinition entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ReportDefinition not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ReportDefinition toEntity(ReportDefinitionDto dto) {
        ReportDefinition e = new ReportDefinition();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ReportDefinitionDto toDto(ReportDefinition e) {
        ReportDefinitionDto d = new ReportDefinitionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
