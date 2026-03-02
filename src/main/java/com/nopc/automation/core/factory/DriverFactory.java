package com.nopc.automation.core.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {
    public static WebDriver createDriver(String browser, boolean headless) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                if (headless) co.addArguments("--headless=new");
                co.addArguments("--start-maximized");
                return new ChromeDriver(co);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions fo = new EdgeOptions();
                if (headless) fo.addArguments("--headless");
                fo.addArguments("--start-maximized");
                return new EdgeDriver(fo);
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
