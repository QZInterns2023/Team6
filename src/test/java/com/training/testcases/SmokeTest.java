package com.training.testcases;

import com.training.pages.*;
import com.training.reporting.ExtentTestManager;

import com.training.utils.CommonUtil;
import org.testng.annotations.Test;

import java.util.Map;

public class SmokeTest extends BaseTest {


    @Test(description = "Login to application")
    public void sampleTest() throws Exception {




        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");
        BasePage.EntityPanel.Deals.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());

    }
}

