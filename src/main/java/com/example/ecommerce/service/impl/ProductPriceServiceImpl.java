package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductPriceDto;
import com.example.ecommerce.entity.ProductPrice;
import com.example.ecommerce.repository.ProductPriceRepository;
import com.example.ecommerce.service.ProductPriceService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    private final ProductPriceRepository repository;

    public ProductPriceServiceImpl(ProductPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductPriceDto create(ProductPriceDto dto) {
        ProductPrice entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ProductPriceDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ProductPrice not found: " + id));
    }

    @Override
    public List<ProductPriceDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductPriceDto update(Long id, ProductPriceDto dto) {
        ProductPrice entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductPrice not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProductPrice toEntity(ProductPriceDto dto) {
        ProductPrice e = new ProductPrice();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ProductPriceDto toDto(ProductPrice e) {
        ProductPriceDto d = new ProductPriceDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
