package com.example.ecommerce.service;

import com.example.ecommerce.dto.SupplierContactDto;
import java.util.List;

public interface SupplierContactService {
    SupplierContactDto create(SupplierContactDto dto);
    SupplierContactDto getById(Long id);
    List<SupplierContactDto> getAll();
    SupplierContactDto update(Long id, SupplierContactDto dto);
    void delete(Long id);
}
