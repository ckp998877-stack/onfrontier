package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductAttributeValueDto;
import java.util.List;

public interface ProductAttributeValueService {
    ProductAttributeValueDto create(ProductAttributeValueDto dto);
    ProductAttributeValueDto getById(Long id);
    List<ProductAttributeValueDto> getAll();
    ProductAttributeValueDto update(Long id, ProductAttributeValueDto dto);
    void delete(Long id);
}
