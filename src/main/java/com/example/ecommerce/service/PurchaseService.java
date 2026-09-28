package com.example.ecommerce.service;

import com.example.ecommerce.dto.PurchaseDto;
import java.util.List;

public interface PurchaseService {
    PurchaseDto create(PurchaseDto dto);
    PurchaseDto getById(Long id);
    List<PurchaseDto> getAll();
    PurchaseDto update(Long id, PurchaseDto dto);
    void delete(Long id);
}
