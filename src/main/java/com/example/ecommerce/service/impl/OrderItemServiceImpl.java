package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.OrderItemDto;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.service.OrderItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItemDto create(OrderItemDto dto) {
        OrderItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public OrderItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("OrderItem not found: " + id));
    }

    @Override
    public List<OrderItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderItemDto update(Long id, OrderItemDto dto) {
        OrderItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private OrderItem toEntity(OrderItemDto dto) {
        OrderItem e = new OrderItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        e.setQuantity(dto.getQuantity());
        e.setOrderId(dto.getOrderId());
        e.setProductId(dto.getProductId());
        return e;
    }

    private OrderItemDto toDto(OrderItem e) {
        OrderItemDto d = new OrderItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        d.setQuantity(e.getQuantity());
        d.setOrderId(e.getOrderId());
        d.setProductId(e.getProductId());
        return d;
    }
}
