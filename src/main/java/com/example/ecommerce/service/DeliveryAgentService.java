package com.example.ecommerce.service;

import com.example.ecommerce.dto.DeliveryAgentDto;
import java.util.List;

public interface DeliveryAgentService {
    DeliveryAgentDto create(DeliveryAgentDto dto);
    DeliveryAgentDto getById(Long id);
    List<DeliveryAgentDto> getAll();
    DeliveryAgentDto update(Long id, DeliveryAgentDto dto);
    void delete(Long id);
}
