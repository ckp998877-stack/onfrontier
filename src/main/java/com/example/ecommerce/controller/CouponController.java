package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CouponDto;
import com.example.ecommerce.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    private final CouponService service;

    public CouponController(CouponService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CouponDto> create(@RequestBody CouponDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<CouponDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CouponDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<CouponDto> update(@PathVariable Long id, @RequestBody CouponDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
