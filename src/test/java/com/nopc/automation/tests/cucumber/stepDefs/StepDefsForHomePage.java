package com.nopc.automation.tests.cucumber.stepDefs;

import com.nopc.automation.constants.AppConstants;
import com.nopc.automation.core.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefsForHomePage{
    private String title;
    @Given("the user launches the application")
    public void the_user_launches_the_application(){}
    @When("the homepage is loaded")
    public void the_homepage_is_loaded(){
        title= DriverManager.getDriver().getTitle();
    }
    @Then("the homepage title should contain {string}")
    public void the_homepage_title_should_contain_(String expectedTitle){
        Assert.assertTrue(title.contains(AppConstants.HOME_TITLE));
    }

}
