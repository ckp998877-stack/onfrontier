package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.NotificationDto;
import com.example.ecommerce.entity.Notification;
import com.example.ecommerce.repository.NotificationRepository;
import com.example.ecommerce.service.NotificationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repository;

    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public NotificationDto create(NotificationDto dto) {
        Notification entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public NotificationDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found: " + id));
    }

    @Override
    public List<NotificationDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public NotificationDto update(Long id, NotificationDto dto) {
        Notification entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Notification toEntity(NotificationDto dto) {
        Notification e = new Notification();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private NotificationDto toDto(Notification e) {
        NotificationDto d = new NotificationDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
