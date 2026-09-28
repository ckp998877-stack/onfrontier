package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ExportJobDto;
import com.example.ecommerce.service.ExportJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exportJobs")
public class ExportJobController {
    private final ExportJobService service;

    public ExportJobController(ExportJobService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExportJobDto> create(@RequestBody ExportJobDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<ExportJobDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExportJobDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<ExportJobDto> update(@PathVariable Long id, @RequestBody ExportJobDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
