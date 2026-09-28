package com.example.ecommerce.service;

import com.example.ecommerce.dto.PurchaseReturnDto;
import java.util.List;

public interface PurchaseReturnService {
    PurchaseReturnDto create(PurchaseReturnDto dto);
    PurchaseReturnDto getById(Long id);
    List<PurchaseReturnDto> getAll();
    PurchaseReturnDto update(Long id, PurchaseReturnDto dto);
    void delete(Long id);
}
