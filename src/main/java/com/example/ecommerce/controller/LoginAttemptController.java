package com.example.ecommerce.controller;

import com.example.ecommerce.dto.LoginAttemptDto;
import com.example.ecommerce.service.LoginAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loginAttempts")
public class LoginAttemptController {
    private final LoginAttemptService service;

    public LoginAttemptController(LoginAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoginAttemptDto> create(@RequestBody LoginAttemptDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<LoginAttemptDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoginAttemptDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<LoginAttemptDto> update(@PathVariable Long id, @RequestBody LoginAttemptDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
