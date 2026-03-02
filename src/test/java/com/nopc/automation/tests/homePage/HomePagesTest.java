package com.nopc.automation.tests.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopc.automation.constants.AppConstants;
import com.nopc.automation.core.driver.DriverManager;
import com.nopc.automation.tests.base.BaseTest;

public class HomePagesTest extends BaseTest {
    @Test(description="TC11 – Verify homepage loads successfully")
    public void tc11_homepage_loads(){
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(title.contains(AppConstants.HOME_TITLE));
    }
}
