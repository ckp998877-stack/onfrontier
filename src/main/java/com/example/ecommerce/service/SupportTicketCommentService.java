package com.example.ecommerce.service;

import com.example.ecommerce.dto.SupportTicketCommentDto;
import java.util.List;

public interface SupportTicketCommentService {
    SupportTicketCommentDto create(SupportTicketCommentDto dto);
    SupportTicketCommentDto getById(Long id);
    List<SupportTicketCommentDto> getAll();
    SupportTicketCommentDto update(Long id, SupportTicketCommentDto dto);
    void delete(Long id);
}
