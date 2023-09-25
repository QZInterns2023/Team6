package com.training.testcases;

import com.training.pages.*;
import com.training.reporting.ExtentTestManager;
import com.training.utils.CommonUtil;
import org.testng.annotations.Test;

import java.util.Map;

public class SmokeTest extends BaseTest {

//    private static final String TESTCASENAME = "TC01";
//
//    Map<String, Map<String, String>> sampleTestData;

    @Test(description = "Login to application")
    public void sampleTest() throws InterruptedException {

        //Map<String, String> testDetails = xlsFile.getExcelRowValuesIntoMapBasedOnKey("sampleSheet", TESTCASENAME);

        //Login to Application
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");
    }
}

