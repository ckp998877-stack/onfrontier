package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CommissionRuleDto;
import com.example.ecommerce.entity.CommissionRule;
import com.example.ecommerce.repository.CommissionRuleRepository;
import com.example.ecommerce.service.CommissionRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommissionRuleServiceImpl implements CommissionRuleService {
    private final CommissionRuleRepository repository;

    public CommissionRuleServiceImpl(CommissionRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public CommissionRuleDto create(CommissionRuleDto dto) {
        CommissionRule entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CommissionRuleDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("CommissionRule not found: " + id));
    }

    @Override
    public List<CommissionRuleDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CommissionRuleDto update(Long id, CommissionRuleDto dto) {
        CommissionRule entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CommissionRule not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CommissionRule toEntity(CommissionRuleDto dto) {
        CommissionRule e = new CommissionRule();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CommissionRuleDto toDto(CommissionRule e) {
        CommissionRuleDto d = new CommissionRuleDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
