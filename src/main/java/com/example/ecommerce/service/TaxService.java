package com.example.ecommerce.service;

import com.example.ecommerce.dto.TaxDto;
import java.util.List;

public interface TaxService {
    TaxDto create(TaxDto dto);
    TaxDto getById(Long id);
    List<TaxDto> getAll();
    TaxDto update(Long id, TaxDto dto);
    void delete(Long id);
}
