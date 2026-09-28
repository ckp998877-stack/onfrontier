package com.example.ecommerce.service;

import com.example.ecommerce.dto.SalesDto;
import java.util.List;

public interface SalesService {
    SalesDto create(SalesDto dto);
    SalesDto getById(Long id);
    List<SalesDto> getAll();
    SalesDto update(Long id, SalesDto dto);
    void delete(Long id);
}
