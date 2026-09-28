package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductAttributeDto;
import java.util.List;

public interface ProductAttributeService {
    ProductAttributeDto create(ProductAttributeDto dto);
    ProductAttributeDto getById(Long id);
    List<ProductAttributeDto> getAll();
    ProductAttributeDto update(Long id, ProductAttributeDto dto);
    void delete(Long id);
}
