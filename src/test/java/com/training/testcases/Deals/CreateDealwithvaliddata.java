package com.training.testcases.Deals;
import com.training.pages.BasePage;
import com.training.pages.DealsPage;

import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;

@Test
public class CreateDealwithvaliddata extends BaseTest {

    public void deal() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());
        ExtentTestManager.getTest().pass("Created deal with Valid Data");
        BasePage.EntityPanel.Deals.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());

        // loginPage.checkPageHeader("Deals");

        DealsPage dealsPage = new DealsPage(getDriver());
       // dealsPage.clickonCreate();
        ExtentTestManager.getTest().pass("Create a Deal");
        HashMap<String, String> deals = new HashMap<String, String>();
      //String s = CommonUtil.getRandomString("Training", 14);
        deals.put("Title","NewDeal" );
        deals.put("Assigned To", "werwer werwer");
        deals.put("Company", "QualiZeal");
        deals.put("Contacts", "Bharat Bharath");
        deals.put("Close Date", "9/28/2023");
       deals.put("Tags","Its service");
        deals.put("Description", "Its sample deal case");
        deals.put("Probability", "80%");
        deals.put("Amount", "20000");
        deals.put("Commission", "2000");
        deals.put("Stage", "Prospect");
        deals.put("Status", "Active");
        dealsPage.createDeals(deals);

        Thread.sleep(5000);
        dealsPage.clickOnSaveButton();
//        dealsPage.refreshingPage();
//        dealsPage.clickOnSaveButton();
      //  ExtentTestManager.getTest().pass("Created a deal successfully");


//        dealsPage.saveDetails();
//        // dealsPage.homePage();
//       dealsPage.verify();
////        dealsPage.deleteRecord(deals);
//   // dealsPage.deletearecord();

    }
//    public String randomStringGenerator(int num){
//        return RandomStringUtils.randomAlphabetic(num);
//    }
//    public String randomIntGenerator(int num){
//        return RandomStringUtils.randomAlphanumeric(num);
//    }

}