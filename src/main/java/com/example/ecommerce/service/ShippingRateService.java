package com.example.ecommerce.service;

import com.example.ecommerce.dto.ShippingRateDto;
import java.util.List;

public interface ShippingRateService {
    ShippingRateDto create(ShippingRateDto dto);
    ShippingRateDto getById(Long id);
    List<ShippingRateDto> getAll();
    ShippingRateDto update(Long id, ShippingRateDto dto);
    void delete(Long id);
}
