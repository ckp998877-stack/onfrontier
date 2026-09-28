package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ExportJobDto;
import com.example.ecommerce.entity.ExportJob;
import com.example.ecommerce.repository.ExportJobRepository;
import com.example.ecommerce.service.ExportJobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExportJobServiceImpl implements ExportJobService {
    private final ExportJobRepository repository;

    public ExportJobServiceImpl(ExportJobRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExportJobDto create(ExportJobDto dto) {
        ExportJob entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ExportJobDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ExportJob not found: " + id));
    }

    @Override
    public List<ExportJobDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ExportJobDto update(Long id, ExportJobDto dto) {
        ExportJob entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ExportJob not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ExportJob toEntity(ExportJobDto dto) {
        ExportJob e = new ExportJob();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ExportJobDto toDto(ExportJob e) {
        ExportJobDto d = new ExportJobDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
