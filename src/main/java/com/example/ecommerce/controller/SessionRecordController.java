package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SessionRecordDto;
import com.example.ecommerce.service.SessionRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sessionRecords")
public class SessionRecordController {
    private final SessionRecordService service;

    public SessionRecordController(SessionRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SessionRecordDto> create(@RequestBody SessionRecordDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionRecordDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SessionRecordDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionRecordDto> update(@PathVariable Long id, @RequestBody SessionRecordDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
