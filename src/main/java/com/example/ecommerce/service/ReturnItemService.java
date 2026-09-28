package com.example.ecommerce.service;

import com.example.ecommerce.dto.ReturnItemDto;
import java.util.List;

public interface ReturnItemService {
    ReturnItemDto create(ReturnItemDto dto);
    ReturnItemDto getById(Long id);
    List<ReturnItemDto> getAll();
    ReturnItemDto update(Long id, ReturnItemDto dto);
    void delete(Long id);
}
