package com.training.testcases.Deals;


import com.training.pages.BasePage;
import com.training.pages.DealsPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.training.support.BrowserFactory.getDriver;
import static com.training.testcases.BaseTest.configurationDetails;

    public class VerifyEditDeal extends BaseTest {

        @Test(description = "Login to application")
        public void editComapnyDts() throws Exception {

            //Login to Application
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
            ExtentTestManager.getTest().pass("Logged in to application");

            DealsPage dealsPage = new DealsPage(getDriver());
            dealsPage.navigateToDeal();
            ExtentTestManager.getTest().pass("Navigate to Deal home page");


            HashMap<String, String> map = new HashMap<>();
            String sDealName = CommonUtil.getRandomString("test", 10);
            map.put("Title",sDealName);
            map.put("Assigned To", "werwer werwer");
            map.put("Company", "qualizeal");
            map.put("Contacts", "Bharat");
            map.put("Close Date", "9/28/2023");
            map.put("Tags", "Its service1");
            map.put("Description", "qualizeal is provide more quality");
            map.put("Probability", "80%");
            map.put("Amount", "20000");
            map.put("Commission", "2000");
            map.put("Stage", "Prospect");
            map.put("Status", "Active");
            map.put("source","Partner");
            dealsPage.createDeals(map);
            dealsPage.checkPageHeader(sDealName);
            ExtentTestManager.getTest().pass("Created Deal." + sDealName);

            dealsPage.navigateToDeal();

            HashMap<String, String> updateDts = new HashMap<>();
            updateDts.put("edit_source", "Referral");

            dealsPage.editDeal(updateDts,sDealName);
            //Thread.sleep(5000);
            //Validate Edit is updating the details
            String sActualValue = dealsPage.getFieldValueFromView("Source");
            dealsPage.getFieldValueFromView("Source");


            Assert.assertTrue(sActualValue.contains("Referral"), "Details are not updated.Expected:".concat("Referral").concat(" Actual:").concat(sActualValue));

        }

        private String randomIntGenerator(int len) {

            return RandomStringUtils.randomAlphanumeric(len);
        }
    }


