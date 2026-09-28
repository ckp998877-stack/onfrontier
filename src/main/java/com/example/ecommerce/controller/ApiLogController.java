package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ApiLogDto;
import com.example.ecommerce.service.ApiLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/apiLogs")
public class ApiLogController {
    private final ApiLogService service;

    public ApiLogController(ApiLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiLogDto> create(@RequestBody ApiLogDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiLogDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ApiLogDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiLogDto> update(@PathVariable Long id, @RequestBody ApiLogDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
