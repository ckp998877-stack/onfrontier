package com.example.ecommerce.service;

import com.example.ecommerce.dto.CommissionRuleDto;
import java.util.List;

public interface CommissionRuleService {
    CommissionRuleDto create(CommissionRuleDto dto);
    CommissionRuleDto getById(Long id);
    List<CommissionRuleDto> getAll();
    CommissionRuleDto update(Long id, CommissionRuleDto dto);
    void delete(Long id);
}
