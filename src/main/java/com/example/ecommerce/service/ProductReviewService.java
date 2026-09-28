package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductReviewDto;
import java.util.List;

public interface ProductReviewService {
    ProductReviewDto create(ProductReviewDto dto);
    ProductReviewDto getById(Long id);
    List<ProductReviewDto> getAll();
    ProductReviewDto update(Long id, ProductReviewDto dto);
    void delete(Long id);
}
