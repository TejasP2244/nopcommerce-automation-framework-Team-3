package com.nopc.automation.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Config {
    private static final Properties PROPS = new Properties();
    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) { PROPS.load(fis); }
        catch (IOException e) { throw new RuntimeException("Failed to load config.properties", e); }
    }
    public static String get(String key) { return System.getProperty(key, PROPS.getProperty(key)); }
}
