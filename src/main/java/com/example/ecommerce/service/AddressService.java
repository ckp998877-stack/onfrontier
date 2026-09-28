package com.example.ecommerce.service;

import com.example.ecommerce.dto.AddressDto;
import java.util.List;

public interface AddressService {
    AddressDto create(AddressDto dto);
    AddressDto getById(Long id);
    List<AddressDto> getAll();
    AddressDto update(Long id, AddressDto dto);
    void delete(Long id);
}
