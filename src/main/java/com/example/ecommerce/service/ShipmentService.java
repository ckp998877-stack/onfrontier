package com.example.ecommerce.service;

import com.example.ecommerce.dto.ShipmentDto;
import java.util.List;

public interface ShipmentService {
    ShipmentDto create(ShipmentDto dto);
    ShipmentDto getById(Long id);
    List<ShipmentDto> getAll();
    ShipmentDto update(Long id, ShipmentDto dto);
    void delete(Long id);
}
