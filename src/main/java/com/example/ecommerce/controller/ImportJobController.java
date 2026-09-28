package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ImportJobDto;
import com.example.ecommerce.service.ImportJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/importJobs")
public class ImportJobController {
    private final ImportJobService service;

    public ImportJobController(ImportJobService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ImportJobDto> create(@RequestBody ImportJobDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<ImportJobDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ImportJobDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<ImportJobDto> update(@PathVariable Long id, @RequestBody ImportJobDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
