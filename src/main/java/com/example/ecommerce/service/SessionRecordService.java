package com.example.ecommerce.service;

import com.example.ecommerce.dto.SessionRecordDto;
import java.util.List;

public interface SessionRecordService {
    SessionRecordDto create(SessionRecordDto dto);
    SessionRecordDto getById(Long id);
    List<SessionRecordDto> getAll();
    SessionRecordDto update(Long id, SessionRecordDto dto);
    void delete(Long id);
}
