package com.nopc.automation.core.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    public static WebDriver getDriver() { return DRIVER.get(); }
    public static void setDriver(WebDriver driver) { DRIVER.set(driver); }
    public static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit(); DRIVER.remove();
        }
    }

}
