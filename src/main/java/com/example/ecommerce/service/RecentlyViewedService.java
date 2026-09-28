package com.example.ecommerce.service;

import com.example.ecommerce.dto.RecentlyViewedDto;
import java.util.List;

public interface RecentlyViewedService {
    RecentlyViewedDto create(RecentlyViewedDto dto);
    RecentlyViewedDto getById(Long id);
    List<RecentlyViewedDto> getAll();
    RecentlyViewedDto update(Long id, RecentlyViewedDto dto);
    void delete(Long id);
}
