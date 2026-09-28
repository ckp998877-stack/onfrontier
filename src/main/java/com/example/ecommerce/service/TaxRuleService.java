package com.example.ecommerce.service;

import com.example.ecommerce.dto.TaxRuleDto;
import java.util.List;

public interface TaxRuleService {
    TaxRuleDto create(TaxRuleDto dto);
    TaxRuleDto getById(Long id);
    List<TaxRuleDto> getAll();
    TaxRuleDto update(Long id, TaxRuleDto dto);
    void delete(Long id);
}
