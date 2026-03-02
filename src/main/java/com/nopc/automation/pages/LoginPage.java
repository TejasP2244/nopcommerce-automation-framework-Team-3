package com.nopc.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    // ---------- Locators ----------
    @FindBy(id="Email") private WebElement email;
    @FindBy(id="Password") private WebElement password;
    @FindBy(css="button.login-button") private WebElement loginBtn;
    @FindBy(css="div.message-error") private WebElement error;
    // ---------- Action Methods ----------
    public void login(String user,String pwd){
        email.clear();
        email.sendKeys(user);
        password.clear();
        password.sendKeys(pwd);
        loginBtn.click();
    }
    public String getError(){
        return error.getText();
    }
}
