package com.example.ecommerce.service;

import com.example.ecommerce.dto.DeliverySlotDto;
import java.util.List;

public interface DeliverySlotService {
    DeliverySlotDto create(DeliverySlotDto dto);
    DeliverySlotDto getById(Long id);
    List<DeliverySlotDto> getAll();
    DeliverySlotDto update(Long id, DeliverySlotDto dto);
    void delete(Long id);
}
