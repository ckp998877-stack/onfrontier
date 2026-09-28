package com.example.ecommerce.service;

import com.example.ecommerce.dto.NotificationDto;
import java.util.List;

public interface NotificationService {
    NotificationDto create(NotificationDto dto);
    NotificationDto getById(Long id);
    List<NotificationDto> getAll();
    NotificationDto update(Long id, NotificationDto dto);
    void delete(Long id);
}
