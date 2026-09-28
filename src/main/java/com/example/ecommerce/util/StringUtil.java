package com.example.ecommerce.util;

public final class StringUtil {
    private StringUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
