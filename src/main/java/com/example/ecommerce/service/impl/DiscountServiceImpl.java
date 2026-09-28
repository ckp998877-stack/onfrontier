package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.DiscountDto;
import com.example.ecommerce.entity.Discount;
import com.example.ecommerce.repository.DiscountRepository;
import com.example.ecommerce.service.DiscountService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository repository;

    public DiscountServiceImpl(DiscountRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiscountDto create(DiscountDto dto) {
        Discount entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public DiscountDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Discount not found: " + id));
    }

    @Override
    public List<DiscountDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DiscountDto update(Long id, DiscountDto dto) {
        Discount entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Discount not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Discount toEntity(DiscountDto dto) {
        Discount e = new Discount();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private DiscountDto toDto(Discount e) {
        DiscountDto d = new DiscountDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
