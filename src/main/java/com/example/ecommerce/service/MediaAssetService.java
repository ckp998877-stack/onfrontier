package com.example.ecommerce.service;

import com.example.ecommerce.dto.MediaAssetDto;
import java.util.List;

public interface MediaAssetService {
    MediaAssetDto create(MediaAssetDto dto);
    MediaAssetDto getById(Long id);
    List<MediaAssetDto> getAll();
    MediaAssetDto update(Long id, MediaAssetDto dto);
    void delete(Long id);
}
