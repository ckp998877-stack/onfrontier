package com.example.ecommerce.service;

import com.example.ecommerce.dto.FileMetadataDto;
import java.util.List;

public interface FileMetadataService {
    FileMetadataDto create(FileMetadataDto dto);
    FileMetadataDto getById(Long id);
    List<FileMetadataDto> getAll();
    FileMetadataDto update(Long id, FileMetadataDto dto);
    void delete(Long id);
}
