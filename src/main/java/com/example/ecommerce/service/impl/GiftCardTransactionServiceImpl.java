package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.GiftCardTransactionDto;
import com.example.ecommerce.entity.GiftCardTransaction;
import com.example.ecommerce.repository.GiftCardTransactionRepository;
import com.example.ecommerce.service.GiftCardTransactionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftCardTransactionServiceImpl implements GiftCardTransactionService {
    private final GiftCardTransactionRepository repository;

    public GiftCardTransactionServiceImpl(GiftCardTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public GiftCardTransactionDto create(GiftCardTransactionDto dto) {
        GiftCardTransaction entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public GiftCardTransactionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("GiftCardTransaction not found: " + id));
    }

    @Override
    public List<GiftCardTransactionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public GiftCardTransactionDto update(Long id, GiftCardTransactionDto dto) {
        GiftCardTransaction entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GiftCardTransaction not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GiftCardTransaction toEntity(GiftCardTransactionDto dto) {
        GiftCardTransaction e = new GiftCardTransaction();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private GiftCardTransactionDto toDto(GiftCardTransaction e) {
        GiftCardTransactionDto d = new GiftCardTransactionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
