package com.example.ecommerce.util;

public final class ValidationUtil {
    private ValidationUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
