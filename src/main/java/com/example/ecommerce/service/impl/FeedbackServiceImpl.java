package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.FeedbackDto;
import com.example.ecommerce.entity.Feedback;
import com.example.ecommerce.repository.FeedbackRepository;
import com.example.ecommerce.service.FeedbackService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository repository;

    public FeedbackServiceImpl(FeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public FeedbackDto create(FeedbackDto dto) {
        Feedback entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public FeedbackDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Feedback not found: " + id));
    }

    @Override
    public List<FeedbackDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public FeedbackDto update(Long id, FeedbackDto dto) {
        Feedback entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Feedback not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Feedback toEntity(FeedbackDto dto) {
        Feedback e = new Feedback();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private FeedbackDto toDto(Feedback e) {
        FeedbackDto d = new FeedbackDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
