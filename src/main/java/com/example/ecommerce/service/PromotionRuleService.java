package com.example.ecommerce.service;

import com.example.ecommerce.dto.PromotionRuleDto;
import java.util.List;

public interface PromotionRuleService {
    PromotionRuleDto create(PromotionRuleDto dto);
    PromotionRuleDto getById(Long id);
    List<PromotionRuleDto> getAll();
    PromotionRuleDto update(Long id, PromotionRuleDto dto);
    void delete(Long id);
}
