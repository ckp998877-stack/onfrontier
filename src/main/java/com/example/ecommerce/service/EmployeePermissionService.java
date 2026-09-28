package com.example.ecommerce.service;

import com.example.ecommerce.dto.EmployeePermissionDto;
import java.util.List;

public interface EmployeePermissionService {
    EmployeePermissionDto create(EmployeePermissionDto dto);
    EmployeePermissionDto getById(Long id);
    List<EmployeePermissionDto> getAll();
    EmployeePermissionDto update(Long id, EmployeePermissionDto dto);
    void delete(Long id);
}
