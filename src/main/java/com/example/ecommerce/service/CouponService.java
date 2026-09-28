package com.example.ecommerce.service;

import com.example.ecommerce.dto.CouponDto;
import java.util.List;

public interface CouponService {
    CouponDto create(CouponDto dto);
    CouponDto getById(Long id);
    List<CouponDto> getAll();
    CouponDto update(Long id, CouponDto dto);
    void delete(Long id);
}
