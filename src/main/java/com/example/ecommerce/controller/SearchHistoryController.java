package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SearchHistoryDto;
import com.example.ecommerce.service.SearchHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/searchHistorys")
public class SearchHistoryController {
    private final SearchHistoryService service;

    public SearchHistoryController(SearchHistoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SearchHistoryDto> create(@RequestBody SearchHistoryDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchHistoryDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SearchHistoryDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SearchHistoryDto> update(@PathVariable Long id, @RequestBody SearchHistoryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
