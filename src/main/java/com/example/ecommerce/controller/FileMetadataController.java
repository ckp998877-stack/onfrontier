package com.example.ecommerce.controller;

import com.example.ecommerce.dto.FileMetadataDto;
import com.example.ecommerce.service.FileMetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fileMetadatas")
public class FileMetadataController {
    private final FileMetadataService service;

    public FileMetadataController(FileMetadataService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FileMetadataDto> create(@RequestBody FileMetadataDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<FileMetadataDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FileMetadataDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<FileMetadataDto> update(@PathVariable Long id, @RequestBody FileMetadataDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
