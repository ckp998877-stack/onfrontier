package com.example.ecommerce.controller;

import com.example.ecommerce.dto.GiftCardDto;
import com.example.ecommerce.service.GiftCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/giftCards")
public class GiftCardController {
    private final GiftCardService service;

    public GiftCardController(GiftCardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GiftCardDto> create(@RequestBody GiftCardDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiftCardDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GiftCardDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiftCardDto> update(@PathVariable Long id, @RequestBody GiftCardDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
