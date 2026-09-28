package com.example.ecommerce.service;

import com.example.ecommerce.dto.PurchaseReturnItemDto;
import java.util.List;

public interface PurchaseReturnItemService {
    PurchaseReturnItemDto create(PurchaseReturnItemDto dto);
    PurchaseReturnItemDto getById(Long id);
    List<PurchaseReturnItemDto> getAll();
    PurchaseReturnItemDto update(Long id, PurchaseReturnItemDto dto);
    void delete(Long id);
}
