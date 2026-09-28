package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductPriceDto;
import java.util.List;

public interface ProductPriceService {
    ProductPriceDto create(ProductPriceDto dto);
    ProductPriceDto getById(Long id);
    List<ProductPriceDto> getAll();
    ProductPriceDto update(Long id, ProductPriceDto dto);
    void delete(Long id);
}
