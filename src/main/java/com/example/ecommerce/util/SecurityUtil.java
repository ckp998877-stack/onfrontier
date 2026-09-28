package com.example.ecommerce.util;

public final class SecurityUtil {
    private SecurityUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
