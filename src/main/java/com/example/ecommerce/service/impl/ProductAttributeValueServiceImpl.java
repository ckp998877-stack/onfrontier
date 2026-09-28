package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductAttributeValueDto;
import com.example.ecommerce.entity.ProductAttributeValue;
import com.example.ecommerce.repository.ProductAttributeValueRepository;
import com.example.ecommerce.service.ProductAttributeValueService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {
    private final ProductAttributeValueRepository repository;

    public ProductAttributeValueServiceImpl(ProductAttributeValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductAttributeValueDto create(ProductAttributeValueDto dto) {
        ProductAttributeValue entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ProductAttributeValueDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ProductAttributeValue not found: " + id));
    }

    @Override
    public List<ProductAttributeValueDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductAttributeValueDto update(Long id, ProductAttributeValueDto dto) {
        ProductAttributeValue entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductAttributeValue not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProductAttributeValue toEntity(ProductAttributeValueDto dto) {
        ProductAttributeValue e = new ProductAttributeValue();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ProductAttributeValueDto toDto(ProductAttributeValue e) {
        ProductAttributeValueDto d = new ProductAttributeValueDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
