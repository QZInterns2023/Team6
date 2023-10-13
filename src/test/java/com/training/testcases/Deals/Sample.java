package com.training.testcases.Deals;



import com.training.pages.DealsPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

    public class Sample extends BaseTest {

        @Test(description = "Login to application")
        public void editDealsDts() throws Exception {

            //Login to Application
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
            ExtentTestManager.getTest().pass("Logged in to application");

            DealsPage dealsPage = new DealsPage(getDriver());
            dealsPage.navigateToDeal();
            ExtentTestManager.getTest().pass("Navigate to Deal home page");
            dealsPage.performTableOperation("NewDeal","view");

            Thread.sleep(5000);

            dealsPage.getFieldValueFromView("Source");
            dealsPage.getFieldValueFromView("Description");


        }

        private String randomIntGenerator(int len) {

            return RandomStringUtils.randomAlphanumeric(len);
        }
    }




