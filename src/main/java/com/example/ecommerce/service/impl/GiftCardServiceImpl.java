package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.GiftCardDto;
import com.example.ecommerce.entity.GiftCard;
import com.example.ecommerce.repository.GiftCardRepository;
import com.example.ecommerce.service.GiftCardService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftCardServiceImpl implements GiftCardService {
    private final GiftCardRepository repository;

    public GiftCardServiceImpl(GiftCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public GiftCardDto create(GiftCardDto dto) {
        GiftCard entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public GiftCardDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("GiftCard not found: " + id));
    }

    @Override
    public List<GiftCardDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public GiftCardDto update(Long id, GiftCardDto dto) {
        GiftCard entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GiftCard not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GiftCard toEntity(GiftCardDto dto) {
        GiftCard e = new GiftCard();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private GiftCardDto toDto(GiftCard e) {
        GiftCardDto d = new GiftCardDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
