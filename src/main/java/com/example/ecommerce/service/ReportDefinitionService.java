package com.example.ecommerce.service;

import com.example.ecommerce.dto.ReportDefinitionDto;
import java.util.List;

public interface ReportDefinitionService {
    ReportDefinitionDto create(ReportDefinitionDto dto);
    ReportDefinitionDto getById(Long id);
    List<ReportDefinitionDto> getAll();
    ReportDefinitionDto update(Long id, ReportDefinitionDto dto);
    void delete(Long id);
}
