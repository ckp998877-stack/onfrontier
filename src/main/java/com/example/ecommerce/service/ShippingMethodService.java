package com.example.ecommerce.service;

import com.example.ecommerce.dto.ShippingMethodDto;
import java.util.List;

public interface ShippingMethodService {
    ShippingMethodDto create(ShippingMethodDto dto);
    ShippingMethodDto getById(Long id);
    List<ShippingMethodDto> getAll();
    ShippingMethodDto update(Long id, ShippingMethodDto dto);
    void delete(Long id);
}
