package com.training.testcases.Deals;

import com.training.pages.DealsPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;

public class VerifyEditDealName extends BaseTest {



        @Test(description = "Login to application")
        public void editDealName() throws Exception {

            //Login to Application
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
            ExtentTestManager.getTest().pass("Logged in to application");

            DealsPage dealspage = new DealsPage(getDriver());
            dealspage.navigateToDeal();;
            ExtentTestManager.getTest().pass("Navigate to company home page");


            HashMap<String, String> map = new HashMap<>();
            String sDealName = CommonUtil.getRandomString("test", 10);
            map.put("Title",sDealName );
            map.put("Assigned To", "werwer werwer");
            map.put("Company", "QualiZeal");
            map.put("Contacts", "Bharat Bharath");
            map.put("Close Date", "9/28/2023");
            map.put("Tags","Its service");
            map.put("Description", "Its sample deal case");
            map.put("Probability", "8%");
            map.put("Amount", "20000");
            map.put("Commission", "2000");
            map.put("Stage", "Prospect");
            map.put("Status", "Active");
            dealspage.createDeals(map);
            dealspage.checkPageHeader(sDealName);
            ExtentTestManager.getTest().pass("Created Company." + sDealName);


            dealspage.navigateToDeal();
            String updatedDealName = "NewName" + sDealName;
            HashMap<String,String> data = new HashMap<>();
            data.put("edit_name", "Bharadwaj");
            dealspage.editDeal(data,sDealName);
//            dealspage.checkPageHeader(data.get("edit_name"));
            dealspage.getFieldValueFromView("Title");
           // dealspage.navigateToDeal();
            //dealspage.checkRecordDisplayed(updatedDealName);
            /*ExtentTestManager.getTest().pass("Updated Deal is displayed in the list."+ updatedDealName);
            dealspage.checkRecordNotDisplayed(sDealName);
            ExtentTestManager.getTest().pass("Old Deal is not displayed in the list."+ sDealName);*/


        }

        private String randomIntGenerator(int len) {

            return RandomStringUtils.randomAlphanumeric(len);
        }
    }


