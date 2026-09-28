package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductVariantDto;
import com.example.ecommerce.entity.ProductVariant;
import com.example.ecommerce.repository.ProductVariantRepository;
import com.example.ecommerce.service.ProductVariantService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {
    private final ProductVariantRepository repository;

    public ProductVariantServiceImpl(ProductVariantRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductVariantDto create(ProductVariantDto dto) {
        ProductVariant entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ProductVariantDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ProductVariant not found: " + id));
    }

    @Override
    public List<ProductVariantDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductVariantDto update(Long id, ProductVariantDto dto) {
        ProductVariant entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductVariant not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProductVariant toEntity(ProductVariantDto dto) {
        ProductVariant e = new ProductVariant();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ProductVariantDto toDto(ProductVariant e) {
        ProductVariantDto d = new ProductVariantDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
