package com.nopc.automation.tests.registration;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopc.automation.pages.*;
import com.nopc.automation.tests.base.BaseTest;
import com.nopc.automation.core.config.Config;

public class RegistrationTests extends BaseTest {
    @Test(description="TC01 – Verify user can register with valid mandatory details")
    public void tc01_register_with_valid_details(){
        HomePage home = new HomePage();
        RegisterPage reg = home.clickRegister();
        String email = "auto" + System.currentTimeMillis() + "@mail.com";
        reg.register("John","Doe", email, "Password123!");
        Assert.assertTrue(reg.getResult().toLowerCase().contains("completed"));
    }
    @Test(description="TC02 – Verify error message when registering with existing email")
    public void tc02_register_existing_email(){
        HomePage home=new HomePage();
        RegisterPage reg=home.clickRegister();
        String usr=Config.get("login.email");
        String pwd=Config.get("login.password");
        reg.register("Josh","Wade",usr,pwd);
        Assert.assertEquals(reg.getEmailError(),"The specified email already exists");
    }
    @Test(description="TC03 – Verify validation message for empty mandatory fields")
    public void tc03_register_empty_fields(){
        HomePage home=new HomePage();
        RegisterPage reg=home.clickRegister();
        reg.register("","","","");
        Assert.assertEquals(reg.getMandatoryFieldError(),"First name is required.");
    }
}
