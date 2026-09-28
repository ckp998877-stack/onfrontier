package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.StockTransferDto;
import com.example.ecommerce.entity.StockTransfer;
import com.example.ecommerce.repository.StockTransferRepository;
import com.example.ecommerce.service.StockTransferService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockTransferServiceImpl implements StockTransferService {
    private final StockTransferRepository repository;

    public StockTransferServiceImpl(StockTransferRepository repository) {
        this.repository = repository;
    }

    @Override
    public StockTransferDto create(StockTransferDto dto) {
        StockTransfer entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public StockTransferDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("StockTransfer not found: " + id));
    }

    @Override
    public List<StockTransferDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public StockTransferDto update(Long id, StockTransferDto dto) {
        StockTransfer entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StockTransfer not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private StockTransfer toEntity(StockTransferDto dto) {
        StockTransfer e = new StockTransfer();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private StockTransferDto toDto(StockTransfer e) {
        StockTransferDto d = new StockTransferDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
