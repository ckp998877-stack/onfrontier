package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CartDto;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.service.CartService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository repository;

    public CartServiceImpl(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartDto create(CartDto dto) {
        Cart entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CartDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found: " + id));
    }

    @Override
    public List<CartDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CartDto update(Long id, CartDto dto) {
        Cart entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Cart toEntity(CartDto dto) {
        Cart e = new Cart();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CartDto toDto(Cart e) {
        CartDto d = new CartDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
