package com.example.ecommerce.util;

public final class CodeGenerator {
    private CodeGenerator() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
