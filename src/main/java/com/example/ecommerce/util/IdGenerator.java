package com.example.ecommerce.util;

public final class IdGenerator {
    private IdGenerator() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
