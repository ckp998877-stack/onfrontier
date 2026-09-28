package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SupportTicketDto;
import com.example.ecommerce.entity.SupportTicket;
import com.example.ecommerce.repository.SupportTicketRepository;
import com.example.ecommerce.service.SupportTicketService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupportTicketServiceImpl implements SupportTicketService {
    private final SupportTicketRepository repository;

    public SupportTicketServiceImpl(SupportTicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupportTicketDto create(SupportTicketDto dto) {
        SupportTicket entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SupportTicketDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SupportTicket not found: " + id));
    }

    @Override
    public List<SupportTicketDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SupportTicketDto update(Long id, SupportTicketDto dto) {
        SupportTicket entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SupportTicket not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SupportTicket toEntity(SupportTicketDto dto) {
        SupportTicket e = new SupportTicket();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SupportTicketDto toDto(SupportTicket e) {
        SupportTicketDto d = new SupportTicketDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
