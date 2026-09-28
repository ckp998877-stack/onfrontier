package com.example.ecommerce.service;

import com.example.ecommerce.dto.RefundDto;
import java.util.List;

public interface RefundService {
    RefundDto create(RefundDto dto);
    RefundDto getById(Long id);
    List<RefundDto> getAll();
    RefundDto update(Long id, RefundDto dto);
    void delete(Long id);
}
