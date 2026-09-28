package com.example.ecommerce.controller;

import com.example.ecommerce.dto.WishlistItemDto;
import com.example.ecommerce.service.WishlistItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/wishlistItems")
public class WishlistItemController {
    private final WishlistItemService service;

    public WishlistItemController(WishlistItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WishlistItemDto> create(@RequestBody WishlistItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<WishlistItemDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<WishlistItemDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<WishlistItemDto> update(@PathVariable Long id, @RequestBody WishlistItemDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
