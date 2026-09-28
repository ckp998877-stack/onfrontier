package com.example.ecommerce.service;

import com.example.ecommerce.dto.ReturnOrderDto;
import java.util.List;

public interface ReturnOrderService {
    ReturnOrderDto create(ReturnOrderDto dto);
    ReturnOrderDto getById(Long id);
    List<ReturnOrderDto> getAll();
    ReturnOrderDto update(Long id, ReturnOrderDto dto);
    void delete(Long id);
}
