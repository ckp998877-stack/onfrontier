package com.example.ecommerce.controller;

import com.example.ecommerce.dto.FaqCategoryDto;
import com.example.ecommerce.service.FaqCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/faqCategorys")
public class FaqCategoryController {
    private final FaqCategoryService service;

    public FaqCategoryController(FaqCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FaqCategoryDto> create(@RequestBody FaqCategoryDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaqCategoryDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FaqCategoryDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaqCategoryDto> update(@PathVariable Long id, @RequestBody FaqCategoryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
