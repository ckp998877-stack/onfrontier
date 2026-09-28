package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.OrderStatusHistoryDto;
import com.example.ecommerce.entity.OrderStatusHistory;
import com.example.ecommerce.repository.OrderStatusHistoryRepository;
import com.example.ecommerce.service.OrderStatusHistoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderStatusHistoryServiceImpl implements OrderStatusHistoryService {
    private final OrderStatusHistoryRepository repository;

    public OrderStatusHistoryServiceImpl(OrderStatusHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderStatusHistoryDto create(OrderStatusHistoryDto dto) {
        OrderStatusHistory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public OrderStatusHistoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("OrderStatusHistory not found: " + id));
    }

    @Override
    public List<OrderStatusHistoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderStatusHistoryDto update(Long id, OrderStatusHistoryDto dto) {
        OrderStatusHistory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderStatusHistory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private OrderStatusHistory toEntity(OrderStatusHistoryDto dto) {
        OrderStatusHistory e = new OrderStatusHistory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private OrderStatusHistoryDto toDto(OrderStatusHistory e) {
        OrderStatusHistoryDto d = new OrderStatusHistoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
