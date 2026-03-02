package com.nopc.automation.pages;

import org.openqa.selenium.support.PageFactory;
import com.nopc.automation.core.driver.DriverManager;

public class BasePage {
    // ---------- 1. Constructor ----------
    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    // ---------- 2. Locators ----------
    // (common)
    // ---------- 3. Action Methods ----------
    // (common)
}
