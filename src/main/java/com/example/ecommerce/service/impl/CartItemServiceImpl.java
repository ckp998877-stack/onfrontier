package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.repository.CartItemRepository;
import com.example.ecommerce.service.CartItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository repository;

    public CartItemServiceImpl(CartItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartItemDto create(CartItemDto dto) {
        CartItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CartItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("CartItem not found: " + id));
    }

    @Override
    public List<CartItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CartItemDto update(Long id, CartItemDto dto) {
        CartItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CartItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CartItem toEntity(CartItemDto dto) {
        CartItem e = new CartItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CartItemDto toDto(CartItem e) {
        CartItemDto d = new CartItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
