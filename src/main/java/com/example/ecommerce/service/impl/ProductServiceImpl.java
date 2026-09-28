package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductDto create(ProductDto dto) {
        Product entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ProductDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
    }

    @Override
    public List<ProductDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        Product entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Product toEntity(ProductDto dto) {
        Product e = new Product();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        e.setStockQuantity(dto.getStockQuantity());
        return e;
    }

    private ProductDto toDto(Product e) {
        ProductDto d = new ProductDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        d.setStockQuantity(e.getStockQuantity());
        return d;
    }
}
