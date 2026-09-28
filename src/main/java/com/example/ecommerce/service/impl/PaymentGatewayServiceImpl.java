package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PaymentGatewayDto;
import com.example.ecommerce.entity.PaymentGateway;
import com.example.ecommerce.repository.PaymentGatewayRepository;
import com.example.ecommerce.service.PaymentGatewayService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {
    private final PaymentGatewayRepository repository;

    public PaymentGatewayServiceImpl(PaymentGatewayRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentGatewayDto create(PaymentGatewayDto dto) {
        PaymentGateway entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PaymentGatewayDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PaymentGateway not found: " + id));
    }

    @Override
    public List<PaymentGatewayDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PaymentGatewayDto update(Long id, PaymentGatewayDto dto) {
        PaymentGateway entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentGateway not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PaymentGateway toEntity(PaymentGatewayDto dto) {
        PaymentGateway e = new PaymentGateway();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PaymentGatewayDto toDto(PaymentGateway e) {
        PaymentGatewayDto d = new PaymentGatewayDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
