package com.example.ecommerce.service;

import com.example.ecommerce.dto.InvoiceDto;
import java.util.List;

public interface InvoiceService {
    InvoiceDto create(InvoiceDto dto);
    InvoiceDto getById(Long id);
    List<InvoiceDto> getAll();
    InvoiceDto update(Long id, InvoiceDto dto);
    void delete(Long id);
}
