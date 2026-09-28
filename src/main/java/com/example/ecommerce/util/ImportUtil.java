package com.example.ecommerce.util;

public final class ImportUtil {
    private ImportUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
