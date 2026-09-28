package com.example.ecommerce.controller;

import com.example.ecommerce.dto.BlogPostDto;
import com.example.ecommerce.service.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/blogPosts")
public class BlogPostController {
    private final BlogPostService service;

    public BlogPostController(BlogPostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BlogPostDto> create(@RequestBody BlogPostDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<BlogPostDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BlogPostDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<BlogPostDto> update(@PathVariable Long id, @RequestBody BlogPostDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
