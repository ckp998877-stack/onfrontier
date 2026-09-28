package com.example.ecommerce.controller;

import com.example.ecommerce.dto.PaymentGatewayDto;
import com.example.ecommerce.service.PaymentGatewayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paymentGateways")
public class PaymentGatewayController {
    private final PaymentGatewayService service;

    public PaymentGatewayController(PaymentGatewayService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PaymentGatewayDto> create(@RequestBody PaymentGatewayDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentGatewayDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PaymentGatewayDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentGatewayDto> update(@PathVariable Long id, @RequestBody PaymentGatewayDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
