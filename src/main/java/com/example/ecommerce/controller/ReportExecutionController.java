package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ReportExecutionDto;
import com.example.ecommerce.service.ReportExecutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reportExecutions")
public class ReportExecutionController {
    private final ReportExecutionService service;

    public ReportExecutionController(ReportExecutionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReportExecutionDto> create(@RequestBody ReportExecutionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<ReportExecutionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReportExecutionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<ReportExecutionDto> update(@PathVariable Long id, @RequestBody ReportExecutionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
