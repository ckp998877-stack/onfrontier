package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ReportScheduleDto;
import com.example.ecommerce.entity.ReportSchedule;
import org.springframework.stereotype.Component;

@Component
public class ReportScheduleMapper {
    public ReportScheduleDto toDto(ReportSchedule entity) {
        ReportScheduleDto dto = new ReportScheduleDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ReportSchedule toEntity(ReportScheduleDto dto) {
        ReportSchedule entity = new ReportSchedule();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
