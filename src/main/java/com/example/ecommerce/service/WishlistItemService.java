package com.example.ecommerce.service;

import com.example.ecommerce.dto.WishlistItemDto;
import java.util.List;

public interface WishlistItemService {
    WishlistItemDto create(WishlistItemDto dto);
    WishlistItemDto getById(Long id);
    List<WishlistItemDto> getAll();
    WishlistItemDto update(Long id, WishlistItemDto dto);
    void delete(Long id);
}
