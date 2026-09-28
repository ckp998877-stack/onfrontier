package com.example.ecommerce.service;

import com.example.ecommerce.dto.AuditLogDto;
import java.util.List;

public interface AuditLogService {
    AuditLogDto create(AuditLogDto dto);
    AuditLogDto getById(Long id);
    List<AuditLogDto> getAll();
    AuditLogDto update(Long id, AuditLogDto dto);
    void delete(Long id);
}
