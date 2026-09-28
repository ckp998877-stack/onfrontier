package com.example.ecommerce.service;

import com.example.ecommerce.dto.DeliveryRouteDto;
import java.util.List;

public interface DeliveryRouteService {
    DeliveryRouteDto create(DeliveryRouteDto dto);
    DeliveryRouteDto getById(Long id);
    List<DeliveryRouteDto> getAll();
    DeliveryRouteDto update(Long id, DeliveryRouteDto dto);
    void delete(Long id);
}
