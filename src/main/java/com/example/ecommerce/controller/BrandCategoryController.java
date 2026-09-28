package com.example.ecommerce.controller;

import com.example.ecommerce.dto.BrandCategoryDto;
import com.example.ecommerce.service.BrandCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/brandCategorys")
public class BrandCategoryController {
    private final BrandCategoryService service;

    public BrandCategoryController(BrandCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BrandCategoryDto> create(@RequestBody BrandCategoryDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<BrandCategoryDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BrandCategoryDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<BrandCategoryDto> update(@PathVariable Long id, @RequestBody BrandCategoryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
