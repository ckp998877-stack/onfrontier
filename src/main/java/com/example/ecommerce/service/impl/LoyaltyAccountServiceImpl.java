package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.LoyaltyAccountDto;
import com.example.ecommerce.entity.LoyaltyAccount;
import com.example.ecommerce.repository.LoyaltyAccountRepository;
import com.example.ecommerce.service.LoyaltyAccountService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoyaltyAccountServiceImpl implements LoyaltyAccountService {
    private final LoyaltyAccountRepository repository;

    public LoyaltyAccountServiceImpl(LoyaltyAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoyaltyAccountDto create(LoyaltyAccountDto dto) {
        LoyaltyAccount entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public LoyaltyAccountDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("LoyaltyAccount not found: " + id));
    }

    @Override
    public List<LoyaltyAccountDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public LoyaltyAccountDto update(Long id, LoyaltyAccountDto dto) {
        LoyaltyAccount entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("LoyaltyAccount not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private LoyaltyAccount toEntity(LoyaltyAccountDto dto) {
        LoyaltyAccount e = new LoyaltyAccount();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private LoyaltyAccountDto toDto(LoyaltyAccount e) {
        LoyaltyAccountDto d = new LoyaltyAccountDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
