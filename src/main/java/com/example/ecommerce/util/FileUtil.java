package com.example.ecommerce.util;

public final class FileUtil {
    private FileUtil() {}
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
