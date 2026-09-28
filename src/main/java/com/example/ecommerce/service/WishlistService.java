package com.example.ecommerce.service;

import com.example.ecommerce.dto.WishlistDto;
import java.util.List;

public interface WishlistService {
    WishlistDto create(WishlistDto dto);
    WishlistDto getById(Long id);
    List<WishlistDto> getAll();
    WishlistDto update(Long id, WishlistDto dto);
    void delete(Long id);
}
