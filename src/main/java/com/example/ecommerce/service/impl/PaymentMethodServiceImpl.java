package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PaymentMethodDto;
import com.example.ecommerce.entity.PaymentMethod;
import com.example.ecommerce.repository.PaymentMethodRepository;
import com.example.ecommerce.service.PaymentMethodService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository repository;

    public PaymentMethodServiceImpl(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentMethodDto create(PaymentMethodDto dto) {
        PaymentMethod entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PaymentMethodDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found: " + id));
    }

    @Override
    public List<PaymentMethodDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PaymentMethodDto update(Long id, PaymentMethodDto dto) {
        PaymentMethod entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PaymentMethod toEntity(PaymentMethodDto dto) {
        PaymentMethod e = new PaymentMethod();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PaymentMethodDto toDto(PaymentMethod e) {
        PaymentMethodDto d = new PaymentMethodDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
