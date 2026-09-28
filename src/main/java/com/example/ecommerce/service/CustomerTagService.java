package com.example.ecommerce.service;

import com.example.ecommerce.dto.CustomerTagDto;
import java.util.List;

public interface CustomerTagService {
    CustomerTagDto create(CustomerTagDto dto);
    CustomerTagDto getById(Long id);
    List<CustomerTagDto> getAll();
    CustomerTagDto update(Long id, CustomerTagDto dto);
    void delete(Long id);
}
