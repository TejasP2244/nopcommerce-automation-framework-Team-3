package com.nopc.automation.tests.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
        glue = "com.nopc.automation.tests.cucumber.stepDefs")
public class TestRunner extends AbstractTestNGCucumberTests {

}
