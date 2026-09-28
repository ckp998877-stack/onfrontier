package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.FileMetadataDto;
import com.example.ecommerce.entity.FileMetadata;
import com.example.ecommerce.repository.FileMetadataRepository;
import com.example.ecommerce.service.FileMetadataService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileMetadataServiceImpl implements FileMetadataService {
    private final FileMetadataRepository repository;

    public FileMetadataServiceImpl(FileMetadataRepository repository) {
        this.repository = repository;
    }

    @Override
    public FileMetadataDto create(FileMetadataDto dto) {
        FileMetadata entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public FileMetadataDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("FileMetadata not found: " + id));
    }

    @Override
    public List<FileMetadataDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public FileMetadataDto update(Long id, FileMetadataDto dto) {
        FileMetadata entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FileMetadata not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private FileMetadata toEntity(FileMetadataDto dto) {
        FileMetadata e = new FileMetadata();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private FileMetadataDto toDto(FileMetadata e) {
        FileMetadataDto d = new FileMetadataDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
