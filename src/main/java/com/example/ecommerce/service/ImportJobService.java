package com.example.ecommerce.service;

import com.example.ecommerce.dto.ImportJobDto;
import java.util.List;

public interface ImportJobService {
    ImportJobDto create(ImportJobDto dto);
    ImportJobDto getById(Long id);
    List<ImportJobDto> getAll();
    ImportJobDto update(Long id, ImportJobDto dto);
    void delete(Long id);
}
