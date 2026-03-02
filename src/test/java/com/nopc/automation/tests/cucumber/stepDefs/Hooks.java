package com.nopc.automation.tests.cucumber.stepDefs;

import com.nopc.automation.tests.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BaseTest {
    BaseTest baseTest=new BaseTest();
    @Before
    public void setUp(){
        baseTest.setUp();
    }
    @After
    public void tearDown(){
        baseTest.tearDown();
    }
}
