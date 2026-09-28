package com.example.ecommerce.service;

import com.example.ecommerce.dto.DepartmentDto;
import java.util.List;

public interface DepartmentService {
    DepartmentDto create(DepartmentDto dto);
    DepartmentDto getById(Long id);
    List<DepartmentDto> getAll();
    DepartmentDto update(Long id, DepartmentDto dto);
    void delete(Long id);
}
