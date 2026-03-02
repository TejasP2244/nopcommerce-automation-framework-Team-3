package com.nopc.automation.listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.nopc.automation.core.driver.DriverManager;

import java.io.ByteArrayInputStream;

public class AllureTestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("---TEST FAILED--- "+result.getName());
        WebDriver driver=DriverManager.getDriver();
        if(driver!=null){
            Allure.addAttachment("Failed Screenshot",new ByteArrayInputStream(((TakesScreenshot)driver).
                    getScreenshotAs(OutputType.BYTES)));
            Allure.addAttachment("Page Source HTML","text/html",driver.getPageSource(),".html");
            System.out.println("Screenshot and Page Source attached to Allure");
        }else{
            System.out.println("Driver is null");
        }

    }
}
