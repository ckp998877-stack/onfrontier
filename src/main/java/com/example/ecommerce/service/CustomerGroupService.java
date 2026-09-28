package com.example.ecommerce.service;

import com.example.ecommerce.dto.CustomerGroupDto;
import java.util.List;

public interface CustomerGroupService {
    CustomerGroupDto create(CustomerGroupDto dto);
    CustomerGroupDto getById(Long id);
    List<CustomerGroupDto> getAll();
    CustomerGroupDto update(Long id, CustomerGroupDto dto);
    void delete(Long id);
}
