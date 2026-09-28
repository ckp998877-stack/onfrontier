package com.example.ecommerce.service;

import com.example.ecommerce.dto.DeliveryDto;
import java.util.List;

public interface DeliveryService {
    DeliveryDto create(DeliveryDto dto);
    DeliveryDto getById(Long id);
    List<DeliveryDto> getAll();
    DeliveryDto update(Long id, DeliveryDto dto);
    void delete(Long id);
}
