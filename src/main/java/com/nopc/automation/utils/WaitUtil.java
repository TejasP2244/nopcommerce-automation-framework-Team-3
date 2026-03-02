package com.nopc.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.nopc.automation.core.config.Config;
import com.nopc.automation.core.driver.DriverManager;

public class WaitUtil {
    private static Duration timeout() { return Duration.ofSeconds(Integer.parseInt(Config.get("explicit.wait.seconds"))); }
    public static WebElement visible(By locator) { return new WebDriverWait(DriverManager.getDriver(), timeout()).
            until(ExpectedConditions.visibilityOfElementLocated(locator)); }
    public static void clickableAndClick(By locator) {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
