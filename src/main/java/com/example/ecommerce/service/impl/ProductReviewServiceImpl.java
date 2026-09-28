package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductReviewDto;
import com.example.ecommerce.entity.ProductReview;
import com.example.ecommerce.repository.ProductReviewRepository;
import com.example.ecommerce.service.ProductReviewService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {
    private final ProductReviewRepository repository;

    public ProductReviewServiceImpl(ProductReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductReviewDto create(ProductReviewDto dto) {
        ProductReview entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ProductReviewDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ProductReview not found: " + id));
    }

    @Override
    public List<ProductReviewDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductReviewDto update(Long id, ProductReviewDto dto) {
        ProductReview entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductReview not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProductReview toEntity(ProductReviewDto dto) {
        ProductReview e = new ProductReview();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ProductReviewDto toDto(ProductReview e) {
        ProductReviewDto d = new ProductReviewDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
