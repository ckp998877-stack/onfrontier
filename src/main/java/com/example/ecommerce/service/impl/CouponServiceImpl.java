package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CouponDto;
import com.example.ecommerce.entity.Coupon;
import com.example.ecommerce.repository.CouponRepository;
import com.example.ecommerce.service.CouponService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponServiceImpl implements CouponService {
    private final CouponRepository repository;

    public CouponServiceImpl(CouponRepository repository) {
        this.repository = repository;
    }

    @Override
    public CouponDto create(CouponDto dto) {
        Coupon entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CouponDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Coupon not found: " + id));
    }

    @Override
    public List<CouponDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CouponDto update(Long id, CouponDto dto) {
        Coupon entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Coupon not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Coupon toEntity(CouponDto dto) {
        Coupon e = new Coupon();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CouponDto toDto(Coupon e) {
        CouponDto d = new CouponDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
