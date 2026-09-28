package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductVariantDto;
import java.util.List;

public interface ProductVariantService {
    ProductVariantDto create(ProductVariantDto dto);
    ProductVariantDto getById(Long id);
    List<ProductVariantDto> getAll();
    ProductVariantDto update(Long id, ProductVariantDto dto);
    void delete(Long id);
}
