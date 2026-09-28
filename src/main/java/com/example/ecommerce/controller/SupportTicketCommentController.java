package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SupportTicketCommentDto;
import com.example.ecommerce.service.SupportTicketCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/supportTicketComments")
public class SupportTicketCommentController {
    private final SupportTicketCommentService service;

    public SupportTicketCommentController(SupportTicketCommentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SupportTicketCommentDto> create(@RequestBody SupportTicketCommentDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<SupportTicketCommentDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SupportTicketCommentDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<SupportTicketCommentDto> update(@PathVariable Long id, @RequestBody SupportTicketCommentDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
