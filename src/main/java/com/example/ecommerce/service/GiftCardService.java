package com.example.ecommerce.service;

import com.example.ecommerce.dto.GiftCardDto;
import java.util.List;

public interface GiftCardService {
    GiftCardDto create(GiftCardDto dto);
    GiftCardDto getById(Long id);
    List<GiftCardDto> getAll();
    GiftCardDto update(Long id, GiftCardDto dto);
    void delete(Long id);
}
