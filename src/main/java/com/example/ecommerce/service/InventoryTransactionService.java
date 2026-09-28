package com.example.ecommerce.service;

import com.example.ecommerce.dto.InventoryTransactionDto;
import java.util.List;

public interface InventoryTransactionService {
    InventoryTransactionDto create(InventoryTransactionDto dto);
    InventoryTransactionDto getById(Long id);
    List<InventoryTransactionDto> getAll();
    InventoryTransactionDto update(Long id, InventoryTransactionDto dto);
    void delete(Long id);
}
