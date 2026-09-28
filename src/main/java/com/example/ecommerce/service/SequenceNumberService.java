package com.example.ecommerce.service;

import com.example.ecommerce.dto.SequenceNumberDto;
import java.util.List;

public interface SequenceNumberService {
    SequenceNumberDto create(SequenceNumberDto dto);
    SequenceNumberDto getById(Long id);
    List<SequenceNumberDto> getAll();
    SequenceNumberDto update(Long id, SequenceNumberDto dto);
    void delete(Long id);
}
