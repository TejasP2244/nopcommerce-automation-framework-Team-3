package com.nopc.automation.pages;

import com.nopc.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import com.nopc.automation.core.driver.DriverManager;
import com.nopc.automation.utils.WebDriverUtil;

public class ProductDetailsPage extends BasePage {
    // ---------- 1. Constructor ----------
    public ProductDetailsPage(){ super(); }
    // ---------- 2. Locators ----------
    private final By name = By.cssSelector("div.product-name h1");
    private final By sku = By.cssSelector("div.sku span.value");
    private final By price = By.cssSelector("div.product-price span");
    private final By qtyInput = By.cssSelector("input.qty-input");
    private final By addToCart = By.cssSelector("button[id^='add-to-cart-button'], button.add-to-cart-button");
    // ---------- 3. Action Methods ----------
    public String getName(){ return WebDriverUtil.text(name); }
    public String getSKU(){ return WebDriverUtil.text(sku); }
    public String getPrice(){ return WebDriverUtil.text(price); }
    public void setQuantity(String qty){
        DriverManager.getDriver().findElement(qtyInput).clear();
        DriverManager.getDriver().findElement(qtyInput).sendKeys(qty);
    }
    public void addToCart(){
        WaitUtil.clickableAndClick(addToCart);
    }
    public boolean isAddedToCart(){
        return DriverManager.getDriver().findElement(addToCart).isDisplayed();
    }
}
