package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.FaqDto;
import com.example.ecommerce.entity.Faq;
import com.example.ecommerce.repository.FaqRepository;
import com.example.ecommerce.service.FaqService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaqServiceImpl implements FaqService {
    private final FaqRepository repository;

    public FaqServiceImpl(FaqRepository repository) {
        this.repository = repository;
    }

    @Override
    public FaqDto create(FaqDto dto) {
        Faq entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public FaqDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Faq not found: " + id));
    }

    @Override
    public List<FaqDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public FaqDto update(Long id, FaqDto dto) {
        Faq entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Faq not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Faq toEntity(FaqDto dto) {
        Faq e = new Faq();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private FaqDto toDto(Faq e) {
        FaqDto d = new FaqDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
