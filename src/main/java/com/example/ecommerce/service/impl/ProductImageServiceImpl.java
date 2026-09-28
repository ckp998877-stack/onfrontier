package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductImageDto;
import com.example.ecommerce.entity.ProductImage;
import com.example.ecommerce.repository.ProductImageRepository;
import com.example.ecommerce.service.ProductImageService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository repository;

    public ProductImageServiceImpl(ProductImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductImageDto create(ProductImageDto dto) {
        ProductImage entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ProductImageDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ProductImage not found: " + id));
    }

    @Override
    public List<ProductImageDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductImageDto update(Long id, ProductImageDto dto) {
        ProductImage entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductImage not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProductImage toEntity(ProductImageDto dto) {
        ProductImage e = new ProductImage();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ProductImageDto toDto(ProductImage e) {
        ProductImageDto d = new ProductImageDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
