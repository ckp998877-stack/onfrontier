package com.example.ecommerce.util;

public final class PasswordUtil {
    private PasswordUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
