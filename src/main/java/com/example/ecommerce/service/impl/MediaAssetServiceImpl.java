package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.MediaAssetDto;
import com.example.ecommerce.entity.MediaAsset;
import com.example.ecommerce.repository.MediaAssetRepository;
import com.example.ecommerce.service.MediaAssetService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaAssetServiceImpl implements MediaAssetService {
    private final MediaAssetRepository repository;

    public MediaAssetServiceImpl(MediaAssetRepository repository) {
        this.repository = repository;
    }

    @Override
    public MediaAssetDto create(MediaAssetDto dto) {
        MediaAsset entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public MediaAssetDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("MediaAsset not found: " + id));
    }

    @Override
    public List<MediaAssetDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public MediaAssetDto update(Long id, MediaAssetDto dto) {
        MediaAsset entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("MediaAsset not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private MediaAsset toEntity(MediaAssetDto dto) {
        MediaAsset e = new MediaAsset();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private MediaAssetDto toDto(MediaAsset e) {
        MediaAssetDto d = new MediaAssetDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
