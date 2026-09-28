package com.example.ecommerce.service;

import com.example.ecommerce.dto.FeedbackDto;
import java.util.List;

public interface FeedbackService {
    FeedbackDto create(FeedbackDto dto);
    FeedbackDto getById(Long id);
    List<FeedbackDto> getAll();
    FeedbackDto update(Long id, FeedbackDto dto);
    void delete(Long id);
}
