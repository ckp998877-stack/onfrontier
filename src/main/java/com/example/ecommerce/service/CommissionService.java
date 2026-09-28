package com.example.ecommerce.service;

import com.example.ecommerce.dto.CommissionDto;
import java.util.List;

public interface CommissionService {
    CommissionDto create(CommissionDto dto);
    CommissionDto getById(Long id);
    List<CommissionDto> getAll();
    CommissionDto update(Long id, CommissionDto dto);
    void delete(Long id);
}
