package com.nopc.automation.pages;

import com.nopc.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import com.nopc.automation.core.driver.DriverManager;
import com.nopc.automation.utils.WebDriverUtil;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    // ---------- 1. Constructor ----------
    public CheckoutPage(){ super(); }
    // ---------- 2. Locators ----------
    private final By loginPrompt = By.cssSelector(".checkout-as-guest-or-register-block");
    private final By coAsGuest=By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div[1]/div[2]/button[1]");
    private final By firstName=By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]");
    private final By lastName=By.xpath("//*[@id=\"BillingNewAddress_LastName\"]");
    private final By emailField=By.xpath("//*[@id=\"BillingNewAddress_Email\"]");
    private final By countryDrp=By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]");
    private final By stateDrp=By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]");
    private final By cityName=By.xpath("//*[@id=\"BillingNewAddress_City\"]");
    private final By addressField=By.xpath("//*[@id=\"BillingNewAddress_Address1\"]");
    private final By pinField=By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]");
    private final By phoneField=By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]");
    private final By conBtn=By.xpath("//*[@id=\"billing-buttons-container\"]/button[2]");
    private final By secConBtn=By.xpath("//*[@id=\"shipping-buttons-container\"]/button");
    private final By thConBtn=By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    private final By foConBtn=By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
    private final By fiConBtn=By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    private final By finConfirmBtn=By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    private final By successMsg=By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div/h2");
    // ---------- 3. Action Methods ----------
    public boolean loginRequired(){ return DriverManager.getDriver().findElements(loginPrompt).size()>0; }
    public void clickCoAsGuest(){
        WaitUtil.clickableAndClick(coAsGuest);
    }
    public void guest(){
        WaitUtil.clickableAndClick(coAsGuest);
    }
    public void fillDetails(){

        WaitUtil.visible(firstName);
        WebDriverUtil.type(firstName,"Henry");
        WaitUtil.visible(lastName);
        WebDriverUtil.type(lastName,"Michael");
        WaitUtil.visible(emailField);
        WebDriverUtil.type(emailField,"henryMo@gmail.com");
        Select countryEle=new Select(WaitUtil.visible(countryDrp));
        countryEle.selectByVisibleText("United States of America");
        Select stateEle=new Select(WaitUtil.visible(stateDrp));
        stateEle.selectByVisibleText("Alaska");
        WaitUtil.visible(cityName);
        WebDriverUtil.type(cityName,"Anchorage");
        WaitUtil.visible(addressField);
        WebDriverUtil.type(addressField,"1000 Arlberg Ave, Girdwood, AK 99587, United States");
        WaitUtil.visible(pinField);
        WebDriverUtil.type(pinField,"99504");
        WaitUtil.visible(phoneField);
        WebDriverUtil.type(phoneField,"8767964367");

        WaitUtil.clickableAndClick(conBtn);
        //WaitUtil.clickableAndClick(secConBtn);
        WaitUtil.clickableAndClick(thConBtn);
        WaitUtil.clickableAndClick(foConBtn);
        WaitUtil.clickableAndClick(fiConBtn);

        WaitUtil.clickableAndClick(finConfirmBtn);
    }
    public String getSuccessMsg(){
        WaitUtil.visible(successMsg);
        return WebDriverUtil.text(successMsg);
    }
}
