package com.nopc.automation.pages;

import org.openqa.selenium.By;
import com.nopc.automation.utils.WaitUtil;
import com.nopc.automation.utils.WebDriverUtil;

public class HomePage extends BasePage {
    // ---------- 1. Constructor ----------
    public HomePage(){ super(); }
    // ---------- 2. Locators ----------
    private final By registerLink = By.cssSelector("a.ico-register");
    private final By loginLink    = By.cssSelector("a.ico-login");
    private final By logoutEle=By.xpath("//a[@class='ico-logout']");
    private final By searchInput  = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("button[type='submit'][class*='search-box-button']");
    private final By computersBtn=By.xpath("//a[text()='Computers']");
    private final By desktopBtn=By.xpath("//img[@alt='Picture for category Desktops']");
    // ---------- 3. Action Methods ----------
    public RegisterPage clickRegister(){
        WaitUtil.clickableAndClick(registerLink);
        return new RegisterPage();
    }
    public LoginPage clickLogin(){
        WaitUtil.clickableAndClick(loginLink);
        return new LoginPage();
    }
    public SearchPage search(String query){
        WebDriverUtil.type(searchInput, query);
        WebDriverUtil.click(searchButton);
        return new SearchPage();
    }
    public void navToDesktops(){
        WaitUtil.clickableAndClick(computersBtn);
        WaitUtil.clickableAndClick(desktopBtn);
    }
    public String getLogoutTxt(){
        WaitUtil.visible(logoutEle);
        return WebDriverUtil.text(logoutEle);
    }
    public String getLoginTxt(){
        WaitUtil.visible(loginLink);
        return WebDriverUtil.text(loginLink);
    }
    public void clickLogout(){
        WaitUtil.clickableAndClick(logoutEle);
    }
}
