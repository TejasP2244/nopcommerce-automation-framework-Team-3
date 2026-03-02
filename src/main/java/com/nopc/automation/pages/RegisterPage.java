package com.nopc.automation.pages;

import com.nopc.automation.utils.WaitUtil;
import com.nopc.automation.utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    // ---------- Locators ----------
    @FindBy(id="FirstName") private WebElement firstName;
    @FindBy(id="LastName") private WebElement lastName;
    @FindBy(id="Email") private WebElement email;
    @FindBy(id="Password") private WebElement password;
    @FindBy(id="ConfirmPassword") private WebElement confirmPassword;
    @FindBy(id="register-button") private WebElement registerBtn;
    @FindBy(css=".result") private WebElement resultMsg;
    private final By  regSameEmailError= By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/form/div/ul/li");
    private final By regMandatoryFieldError=By.xpath("//span[@id='FirstName-error']");
    // ---------- Action Methods ----------
    public void register(String fn,String ln,String mail,String pwd){
        firstName.sendKeys(fn);
        lastName.sendKeys(ln); email.sendKeys(mail);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
        registerBtn.click();
    }
    public String getResult(){
        return resultMsg.getText();
    }
    public String getEmailError(){
        WaitUtil.visible(regSameEmailError);
        return WebDriverUtil.text(regSameEmailError);
    }
    public String getMandatoryFieldError(){
        WaitUtil.visible(regMandatoryFieldError);
        return WebDriverUtil.text(regMandatoryFieldError);
    }
}
