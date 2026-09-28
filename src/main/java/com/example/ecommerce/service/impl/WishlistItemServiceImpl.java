package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.WishlistItemDto;
import com.example.ecommerce.entity.WishlistItem;
import com.example.ecommerce.repository.WishlistItemRepository;
import com.example.ecommerce.service.WishlistItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistItemServiceImpl implements WishlistItemService {
    private final WishlistItemRepository repository;

    public WishlistItemServiceImpl(WishlistItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public WishlistItemDto create(WishlistItemDto dto) {
        WishlistItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public WishlistItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("WishlistItem not found: " + id));
    }

    @Override
    public List<WishlistItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public WishlistItemDto update(Long id, WishlistItemDto dto) {
        WishlistItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WishlistItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private WishlistItem toEntity(WishlistItemDto dto) {
        WishlistItem e = new WishlistItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private WishlistItemDto toDto(WishlistItem e) {
        WishlistItemDto d = new WishlistItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
