package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SupportTicketCommentDto;
import com.example.ecommerce.entity.SupportTicketComment;
import com.example.ecommerce.repository.SupportTicketCommentRepository;
import com.example.ecommerce.service.SupportTicketCommentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupportTicketCommentServiceImpl implements SupportTicketCommentService {
    private final SupportTicketCommentRepository repository;

    public SupportTicketCommentServiceImpl(SupportTicketCommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupportTicketCommentDto create(SupportTicketCommentDto dto) {
        SupportTicketComment entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SupportTicketCommentDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SupportTicketComment not found: " + id));
    }

    @Override
    public List<SupportTicketCommentDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SupportTicketCommentDto update(Long id, SupportTicketCommentDto dto) {
        SupportTicketComment entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SupportTicketComment not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SupportTicketComment toEntity(SupportTicketCommentDto dto) {
        SupportTicketComment e = new SupportTicketComment();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SupportTicketCommentDto toDto(SupportTicketComment e) {
        SupportTicketCommentDto d = new SupportTicketCommentDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
