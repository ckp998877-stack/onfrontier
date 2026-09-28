package com.example.ecommerce.service;

import com.example.ecommerce.dto.BrandDto;
import java.util.List;

public interface BrandService {
    BrandDto create(BrandDto dto);
    BrandDto getById(Long id);
    List<BrandDto> getAll();
    BrandDto update(Long id, BrandDto dto);
    void delete(Long id);
}
