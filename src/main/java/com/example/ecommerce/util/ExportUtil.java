package com.example.ecommerce.util;

public final class ExportUtil {
    private ExportUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
