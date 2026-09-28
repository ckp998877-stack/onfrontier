package com.example.ecommerce.service;

import com.example.ecommerce.dto.FaqDto;
import java.util.List;

public interface FaqService {
    FaqDto create(FaqDto dto);
    FaqDto getById(Long id);
    List<FaqDto> getAll();
    FaqDto update(Long id, FaqDto dto);
    void delete(Long id);
}
