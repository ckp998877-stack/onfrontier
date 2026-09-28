package com.example.ecommerce.service;

import com.example.ecommerce.dto.ReportExecutionDto;
import java.util.List;

public interface ReportExecutionService {
    ReportExecutionDto create(ReportExecutionDto dto);
    ReportExecutionDto getById(Long id);
    List<ReportExecutionDto> getAll();
    ReportExecutionDto update(Long id, ReportExecutionDto dto);
    void delete(Long id);
}
