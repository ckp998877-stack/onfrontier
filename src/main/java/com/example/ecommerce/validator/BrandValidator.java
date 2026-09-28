package com.example.ecommerce.validator;

import org.springframework.stereotype.Component;

@Component
public class BrandValidator {
    public boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
