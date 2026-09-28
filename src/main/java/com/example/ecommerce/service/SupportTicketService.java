package com.example.ecommerce.service;

import com.example.ecommerce.dto.SupportTicketDto;
import java.util.List;

public interface SupportTicketService {
    SupportTicketDto create(SupportTicketDto dto);
    SupportTicketDto getById(Long id);
    List<SupportTicketDto> getAll();
    SupportTicketDto update(Long id, SupportTicketDto dto);
    void delete(Long id);
}
