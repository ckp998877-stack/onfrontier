package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductImageDto;
import java.util.List;

public interface ProductImageService {
    ProductImageDto create(ProductImageDto dto);
    ProductImageDto getById(Long id);
    List<ProductImageDto> getAll();
    ProductImageDto update(Long id, ProductImageDto dto);
    void delete(Long id);
}
