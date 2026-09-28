package com.example.ecommerce.service;

import com.example.ecommerce.dto.TaxRateDto;
import java.util.List;

public interface TaxRateService {
    TaxRateDto create(TaxRateDto dto);
    TaxRateDto getById(Long id);
    List<TaxRateDto> getAll();
    TaxRateDto update(Long id, TaxRateDto dto);
    void delete(Long id);
}
