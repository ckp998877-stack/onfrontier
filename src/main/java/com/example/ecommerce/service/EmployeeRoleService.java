package com.example.ecommerce.service;

import com.example.ecommerce.dto.EmployeeRoleDto;
import java.util.List;

public interface EmployeeRoleService {
    EmployeeRoleDto create(EmployeeRoleDto dto);
    EmployeeRoleDto getById(Long id);
    List<EmployeeRoleDto> getAll();
    EmployeeRoleDto update(Long id, EmployeeRoleDto dto);
    void delete(Long id);
}
