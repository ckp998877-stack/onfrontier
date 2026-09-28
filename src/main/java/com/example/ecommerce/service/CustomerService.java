package com.example.ecommerce.service;

import com.example.ecommerce.dto.CustomerDto;
import java.util.List;

public interface CustomerService {
    CustomerDto create(CustomerDto dto);
    CustomerDto getById(Long id);
    List<CustomerDto> getAll();
    CustomerDto update(Long id, CustomerDto dto);
    void delete(Long id);
}
