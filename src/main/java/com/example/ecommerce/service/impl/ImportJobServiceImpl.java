package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ImportJobDto;
import com.example.ecommerce.entity.ImportJob;
import com.example.ecommerce.repository.ImportJobRepository;
import com.example.ecommerce.service.ImportJobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImportJobServiceImpl implements ImportJobService {
    private final ImportJobRepository repository;

    public ImportJobServiceImpl(ImportJobRepository repository) {
        this.repository = repository;
    }

    @Override
    public ImportJobDto create(ImportJobDto dto) {
        ImportJob entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ImportJobDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ImportJob not found: " + id));
    }

    @Override
    public List<ImportJobDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ImportJobDto update(Long id, ImportJobDto dto) {
        ImportJob entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ImportJob not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ImportJob toEntity(ImportJobDto dto) {
        ImportJob e = new ImportJob();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ImportJobDto toDto(ImportJob e) {
        ImportJobDto d = new ImportJobDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
