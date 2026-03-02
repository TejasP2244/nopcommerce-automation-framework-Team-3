package com.nopc.automation.utils;

import org.openqa.selenium.By;
import com.nopc.automation.core.driver.DriverManager;

public class WebDriverUtil {
    public static void type(By locator, String value) {
        DriverManager.getDriver().findElement(locator).clear();
        DriverManager.getDriver().findElement(locator).sendKeys(value);
    }
    public static void click(By locator) {
        DriverManager.getDriver().findElement(locator).click();
    }
    public static String text(By locator) {
        return DriverManager.getDriver().findElement(locator).getText();
    }
}
