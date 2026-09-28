package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PaymentTransactionDto;
import com.example.ecommerce.entity.PaymentTransaction;
import com.example.ecommerce.repository.PaymentTransactionRepository;
import com.example.ecommerce.service.PaymentTransactionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {
    private final PaymentTransactionRepository repository;

    public PaymentTransactionServiceImpl(PaymentTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentTransactionDto create(PaymentTransactionDto dto) {
        PaymentTransaction entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PaymentTransactionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PaymentTransaction not found: " + id));
    }

    @Override
    public List<PaymentTransactionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PaymentTransactionDto update(Long id, PaymentTransactionDto dto) {
        PaymentTransaction entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentTransaction not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PaymentTransaction toEntity(PaymentTransactionDto dto) {
        PaymentTransaction e = new PaymentTransaction();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PaymentTransactionDto toDto(PaymentTransaction e) {
        PaymentTransactionDto d = new PaymentTransactionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
