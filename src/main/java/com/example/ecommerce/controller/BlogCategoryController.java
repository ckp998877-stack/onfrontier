package com.example.ecommerce.controller;

import com.example.ecommerce.dto.BlogCategoryDto;
import com.example.ecommerce.service.BlogCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/blogCategorys")
public class BlogCategoryController {
    private final BlogCategoryService service;

    public BlogCategoryController(BlogCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BlogCategoryDto> create(@RequestBody BlogCategoryDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogCategoryDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BlogCategoryDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogCategoryDto> update(@PathVariable Long id, @RequestBody BlogCategoryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
