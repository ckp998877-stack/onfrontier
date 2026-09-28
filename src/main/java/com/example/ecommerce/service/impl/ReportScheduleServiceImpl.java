package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ReportScheduleDto;
import com.example.ecommerce.entity.ReportSchedule;
import com.example.ecommerce.repository.ReportScheduleRepository;
import com.example.ecommerce.service.ReportScheduleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportScheduleServiceImpl implements ReportScheduleService {
    private final ReportScheduleRepository repository;

    public ReportScheduleServiceImpl(ReportScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReportScheduleDto create(ReportScheduleDto dto) {
        ReportSchedule entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ReportScheduleDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ReportSchedule not found: " + id));
    }

    @Override
    public List<ReportScheduleDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReportScheduleDto update(Long id, ReportScheduleDto dto) {
        ReportSchedule entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ReportSchedule not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ReportSchedule toEntity(ReportScheduleDto dto) {
        ReportSchedule e = new ReportSchedule();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ReportScheduleDto toDto(ReportSchedule e) {
        ReportScheduleDto d = new ReportScheduleDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
