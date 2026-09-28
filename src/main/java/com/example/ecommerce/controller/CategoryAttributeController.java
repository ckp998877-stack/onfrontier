package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CategoryAttributeDto;
import com.example.ecommerce.service.CategoryAttributeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categoryAttributes")
public class CategoryAttributeController {
    private final CategoryAttributeService service;

    public CategoryAttributeController(CategoryAttributeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoryAttributeDto> create(@RequestBody CategoryAttributeDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryAttributeDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryAttributeDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryAttributeDto> update(@PathVariable Long id, @RequestBody CategoryAttributeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
