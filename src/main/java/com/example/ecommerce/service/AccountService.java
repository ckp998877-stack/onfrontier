package com.example.ecommerce.service;

import com.example.ecommerce.dto.AccountDto;
import java.util.List;

public interface AccountService {
    AccountDto create(AccountDto dto);
    AccountDto getById(Long id);
    List<AccountDto> getAll();
    AccountDto update(Long id, AccountDto dto);
    void delete(Long id);
}
