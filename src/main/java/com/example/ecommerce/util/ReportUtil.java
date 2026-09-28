package com.example.ecommerce.util;

public final class ReportUtil {
    private ReportUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
