package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ReportDefinitionDto;
import com.example.ecommerce.service.ReportDefinitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reportDefinitions")
public class ReportDefinitionController {
    private final ReportDefinitionService service;

    public ReportDefinitionController(ReportDefinitionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReportDefinitionDto> create(@RequestBody ReportDefinitionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDefinitionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReportDefinitionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportDefinitionDto> update(@PathVariable Long id, @RequestBody ReportDefinitionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
