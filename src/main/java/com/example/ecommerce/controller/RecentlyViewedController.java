package com.example.ecommerce.controller;

import com.example.ecommerce.dto.RecentlyViewedDto;
import com.example.ecommerce.service.RecentlyViewedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recentlyVieweds")
public class RecentlyViewedController {
    private final RecentlyViewedService service;

    public RecentlyViewedController(RecentlyViewedService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecentlyViewedDto> create(@RequestBody RecentlyViewedDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<RecentlyViewedDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecentlyViewedDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<RecentlyViewedDto> update(@PathVariable Long id, @RequestBody RecentlyViewedDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
