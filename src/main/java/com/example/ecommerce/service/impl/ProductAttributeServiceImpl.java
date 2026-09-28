package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductAttributeDto;
import com.example.ecommerce.entity.ProductAttribute;
import com.example.ecommerce.repository.ProductAttributeRepository;
import com.example.ecommerce.service.ProductAttributeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    private final ProductAttributeRepository repository;

    public ProductAttributeServiceImpl(ProductAttributeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductAttributeDto create(ProductAttributeDto dto) {
        ProductAttribute entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ProductAttributeDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ProductAttribute not found: " + id));
    }

    @Override
    public List<ProductAttributeDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductAttributeDto update(Long id, ProductAttributeDto dto) {
        ProductAttribute entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductAttribute not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProductAttribute toEntity(ProductAttributeDto dto) {
        ProductAttribute e = new ProductAttribute();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ProductAttributeDto toDto(ProductAttribute e) {
        ProductAttributeDto d = new ProductAttributeDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
