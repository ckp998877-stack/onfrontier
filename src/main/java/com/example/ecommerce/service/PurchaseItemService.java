package com.example.ecommerce.service;

import com.example.ecommerce.dto.PurchaseItemDto;
import java.util.List;

public interface PurchaseItemService {
    PurchaseItemDto create(PurchaseItemDto dto);
    PurchaseItemDto getById(Long id);
    List<PurchaseItemDto> getAll();
    PurchaseItemDto update(Long id, PurchaseItemDto dto);
    void delete(Long id);
}
