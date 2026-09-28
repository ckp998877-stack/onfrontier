package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.AccountDto;
import com.example.ecommerce.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDto toDto(Account entity) {
        AccountDto dto = new AccountDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Account toEntity(AccountDto dto) {
        Account entity = new Account();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
