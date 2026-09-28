package com.example.ecommerce.service;

import com.example.ecommerce.dto.SupplierDto;
import java.util.List;

public interface SupplierService {
    SupplierDto create(SupplierDto dto);
    SupplierDto getById(Long id);
    List<SupplierDto> getAll();
    SupplierDto update(Long id, SupplierDto dto);
    void delete(Long id);
}
