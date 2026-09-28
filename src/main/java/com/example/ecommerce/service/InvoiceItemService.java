package com.example.ecommerce.service;

import com.example.ecommerce.dto.InvoiceItemDto;
import java.util.List;

public interface InvoiceItemService {
    InvoiceItemDto create(InvoiceItemDto dto);
    InvoiceItemDto getById(Long id);
    List<InvoiceItemDto> getAll();
    InvoiceItemDto update(Long id, InvoiceItemDto dto);
    void delete(Long id);
}
