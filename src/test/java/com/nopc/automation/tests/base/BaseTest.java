package com.nopc.automation.tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.nopc.automation.core.config.Config;
import com.nopc.automation.core.driver.DriverManager;
import com.nopc.automation.core.factory.DriverFactory;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = System.getProperty("browser", Config.get("browser"));
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", Config.get("headless")));
        WebDriver driver = DriverFactory.createDriver(browser, headless);
        DriverManager.setDriver(driver);
        driver.manage().deleteAllCookies();
        driver.get(Config.get("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
