package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.WishlistDto;
import com.example.ecommerce.entity.Wishlist;
import com.example.ecommerce.repository.WishlistRepository;
import com.example.ecommerce.service.WishlistService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository repository;

    public WishlistServiceImpl(WishlistRepository repository) {
        this.repository = repository;
    }

    @Override
    public WishlistDto create(WishlistDto dto) {
        Wishlist entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public WishlistDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found: " + id));
    }

    @Override
    public List<WishlistDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public WishlistDto update(Long id, WishlistDto dto) {
        Wishlist entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Wishlist toEntity(WishlistDto dto) {
        Wishlist e = new Wishlist();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private WishlistDto toDto(Wishlist e) {
        WishlistDto d = new WishlistDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
