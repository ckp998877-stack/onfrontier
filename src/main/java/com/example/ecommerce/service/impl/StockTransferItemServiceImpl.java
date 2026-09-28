package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.StockTransferItemDto;
import com.example.ecommerce.entity.StockTransferItem;
import com.example.ecommerce.repository.StockTransferItemRepository;
import com.example.ecommerce.service.StockTransferItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockTransferItemServiceImpl implements StockTransferItemService {
    private final StockTransferItemRepository repository;

    public StockTransferItemServiceImpl(StockTransferItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public StockTransferItemDto create(StockTransferItemDto dto) {
        StockTransferItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public StockTransferItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("StockTransferItem not found: " + id));
    }

    @Override
    public List<StockTransferItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public StockTransferItemDto update(Long id, StockTransferItemDto dto) {
        StockTransferItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StockTransferItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private StockTransferItem toEntity(StockTransferItemDto dto) {
        StockTransferItem e = new StockTransferItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private StockTransferItemDto toDto(StockTransferItem e) {
        StockTransferItemDto d = new StockTransferItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
