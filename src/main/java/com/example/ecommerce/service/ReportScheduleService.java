package com.example.ecommerce.service;

import com.example.ecommerce.dto.ReportScheduleDto;
import java.util.List;

public interface ReportScheduleService {
    ReportScheduleDto create(ReportScheduleDto dto);
    ReportScheduleDto getById(Long id);
    List<ReportScheduleDto> getAll();
    ReportScheduleDto update(Long id, ReportScheduleDto dto);
    void delete(Long id);
}
