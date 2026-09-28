package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SequenceNumberDto;
import com.example.ecommerce.service.SequenceNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sequenceNumbers")
public class SequenceNumberController {
    private final SequenceNumberService service;

    public SequenceNumberController(SequenceNumberService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SequenceNumberDto> create(@RequestBody SequenceNumberDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SequenceNumberDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SequenceNumberDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SequenceNumberDto> update(@PathVariable Long id, @RequestBody SequenceNumberDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
