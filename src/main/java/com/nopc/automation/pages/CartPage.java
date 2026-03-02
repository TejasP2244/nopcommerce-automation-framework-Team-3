package com.nopc.automation.pages;

import com.nopc.automation.core.driver.DriverManager;
import com.nopc.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import com.nopc.automation.utils.WebDriverUtil;

public class CartPage extends BasePage {
    // ---------- 1. Constructor ----------
    public CartPage(){
        super();
    }
    // ---------- 2. Locators ----------
    private final By cartLink = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
    private final By qtyInput = By.cssSelector("input.qty-input");
    private final By indPrice=By.xpath("//span[@class='product-unit-price']");
    private final By updateBtn = By.xpath("//div[@class='quantity up']");
    private final By removeChk = By.xpath("//button[@class='remove-btn']");
    private final By total = By.xpath("//span[@class='product-subtotal']");
    private final By terms = By.xpath("//input[@id='termsofservice']");
    private final By checkoutBtn = By.id("checkout");
    private final By cartMsg=By.xpath("//div[@class='no-data']");
    private final By skuNum=By.xpath("//span[@class='sku-number']");
    // ---------- 3. Action Methods ----------

    public CartPage open(){
        WaitUtil.clickableAndClick(cartLink);
        return this;
    }
    public void updateQuantity(){
        WaitUtil.clickableAndClick(updateBtn);
    }
    public void removeProduct(){
        WaitUtil.clickableAndClick(removeChk);
    }

    public String getIndPrice(){
        WaitUtil.visible(indPrice);
        return WebDriverUtil.text(indPrice);
    }
    public String getQuant(){
        WaitUtil.visible(qtyInput);
        return DriverManager.getDriver().findElement(qtyInput).getAttribute("value");
    }
    public boolean isSkuNumber(){
        WaitUtil.visible(skuNum);
        return DriverManager.getDriver().findElement(skuNum).isDisplayed();
    }
    public String getTotal(){
        WaitUtil.visible(total);
        return WebDriverUtil.text(total);
    }
    public String getEmptyCartMsg(){
        WaitUtil.visible(cartMsg);
        return WebDriverUtil.text(cartMsg);
    }
    public CheckoutPage proceedToCheckout(){
        WaitUtil.clickableAndClick(terms);
        WaitUtil.clickableAndClick(checkoutBtn);
        return new CheckoutPage();
    }


}
