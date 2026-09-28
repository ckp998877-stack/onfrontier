package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PaymentDto;
import com.example.ecommerce.entity.Payment;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.service.PaymentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentDto create(PaymentDto dto) {
        Payment entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PaymentDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found: " + id));
    }

    @Override
    public List<PaymentDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PaymentDto update(Long id, PaymentDto dto) {
        Payment entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Payment toEntity(PaymentDto dto) {
        Payment e = new Payment();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PaymentDto toDto(Payment e) {
        PaymentDto d = new PaymentDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
