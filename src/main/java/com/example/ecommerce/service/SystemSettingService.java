package com.example.ecommerce.service;

import com.example.ecommerce.dto.SystemSettingDto;
import java.util.List;

public interface SystemSettingService {
    SystemSettingDto create(SystemSettingDto dto);
    SystemSettingDto getById(Long id);
    List<SystemSettingDto> getAll();
    SystemSettingDto update(Long id, SystemSettingDto dto);
    void delete(Long id);
}
