package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.AccountDto;
import com.example.ecommerce.entity.Account;
import com.example.ecommerce.repository.AccountRepository;
import com.example.ecommerce.service.AccountService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountDto create(AccountDto dto) {
        Account entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public AccountDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + id));
    }

    @Override
    public List<AccountDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public AccountDto update(Long id, AccountDto dto) {
        Account entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Account toEntity(AccountDto dto) {
        Account e = new Account();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private AccountDto toDto(Account e) {
        AccountDto d = new AccountDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
