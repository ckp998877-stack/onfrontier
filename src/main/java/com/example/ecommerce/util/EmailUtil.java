package com.example.ecommerce.util;

public final class EmailUtil {
    private EmailUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
