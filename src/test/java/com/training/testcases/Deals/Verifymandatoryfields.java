package com.training.testcases.Deals;

import com.training.pages.BasePage;
import com.training.pages.DealsPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
@Test
public class Verifymandatoryfields extends BaseTest {
    public void deal() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());
        ExtentTestManager.getTest().pass("Logged in to application");
        BasePage.EntityPanel.Deals.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());

        // loginPage.checkPageHeader("Deals");

        DealsPage dealsPage = new DealsPage(getDriver());
        // dealsPage.clickonCreate();
        ExtentTestManager.getTest().pass("Verify a Deal");
        HashMap<String, String> deals = new HashMap<String, String>();
        String s = CommonUtil.getRandomString("Training", 14);
        deals.put("Title", s);
//        deals.put("Assigned To", "werwer werwer");
//        deals.put("Company", s);
//        deals.put("Contacts", "niru katroth");
//        deals.put("Close Date", "9/28/2023");
//        deals.put("Tags",s);
//        deals.put("Description", s);
//        deals.put("Probability", "80%");
//        deals.put("Amount", "20000");
//        deals.put("Commission", "2000");
//        deals.put("Stage", "Prospect");
//        deals.put("Status", "Active");
        dealsPage.createDeals(deals);

    }
}
