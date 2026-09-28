package com.example.ecommerce.service;

import com.example.ecommerce.dto.ExportJobDto;
import java.util.List;

public interface ExportJobService {
    ExportJobDto create(ExportJobDto dto);
    ExportJobDto getById(Long id);
    List<ExportJobDto> getAll();
    ExportJobDto update(Long id, ExportJobDto dto);
    void delete(Long id);
}
