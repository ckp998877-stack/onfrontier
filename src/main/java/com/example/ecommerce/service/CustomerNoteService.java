package com.example.ecommerce.service;

import com.example.ecommerce.dto.CustomerNoteDto;
import java.util.List;

public interface CustomerNoteService {
    CustomerNoteDto create(CustomerNoteDto dto);
    CustomerNoteDto getById(Long id);
    List<CustomerNoteDto> getAll();
    CustomerNoteDto update(Long id, CustomerNoteDto dto);
    void delete(Long id);
}
