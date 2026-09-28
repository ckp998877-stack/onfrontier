package com.example.ecommerce.service;

import com.example.ecommerce.dto.PromotionDto;
import java.util.List;

public interface PromotionService {
    PromotionDto create(PromotionDto dto);
    PromotionDto getById(Long id);
    List<PromotionDto> getAll();
    PromotionDto update(Long id, PromotionDto dto);
    void delete(Long id);
}
