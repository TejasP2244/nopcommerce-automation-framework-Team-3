package com.nopc.automation.tests.login;

import com.nopc.automation.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nopc.automation.core.config.Config;
import com.nopc.automation.pages.*;
import com.nopc.automation.tests.base.BaseTest;

import java.io.IOException;

public class LoginTests extends BaseTest {
    @DataProvider(name="invalidLoginData")
    public Object[][] invalidLoginData() throws IOException {
        String path="C:\\Users\\2464193\\Downloads\\nopcommerce-ordered-noapi\\nopcommerce-ordered-noapi\\src\\test\\resources\\LoginData2.xlsx";
        return ExcelUtil.getData(path,"Sheet1");
    }
    @Test(description="TC06 – Verify login with valid credentials")
    public void tc06_login_valid(){
        String user = Config.get("login.email");
        String pwd  = Config.get("login.password");
        HomePage home = new HomePage();
        LoginPage login = home.clickLogin();
        login.login(user, pwd);
        Assert.assertEquals(home.getLogoutTxt(),"Log out"); // Replace with assertion for logged-in state
    }
    @Test(dataProvider = "invalidLoginData", description="TC07 – Verify login fails with invalid password")
    public void tc07_login_invalid_password(String email,String password){
        HomePage home=new HomePage();
        LoginPage login=home.clickLogin();
        login.login(email,password);
        Assert.assertTrue(login.getError().length()>0);
    }
    @Test(description="TC08 – Verify login fails with unregistered email")
    public void tc08_login_unregistered(){
        HomePage home=new HomePage();
        LoginPage login=home.clickLogin();
        login.login("nouser"+System.currentTimeMillis()+"@mail.com","12345678");
        Assert.assertTrue(login.getError().length()>0);
    }
    @Test(description="TC09 – Verify logout functionality")
    public void tc09_logout(){
        String user = Config.get("login.email");
        String pwd  = Config.get("login.password");
        HomePage home = new HomePage();
        LoginPage login = home.clickLogin();
        login.login(user, pwd);
        home.clickLogout();
        Assert.assertEquals(home.getLoginTxt(),"Log in");
    }
}
