package com.example.ecommerce.service;

import com.example.ecommerce.dto.SavedAddressDto;
import java.util.List;

public interface SavedAddressService {
    SavedAddressDto create(SavedAddressDto dto);
    SavedAddressDto getById(Long id);
    List<SavedAddressDto> getAll();
    SavedAddressDto update(Long id, SavedAddressDto dto);
    void delete(Long id);
}
