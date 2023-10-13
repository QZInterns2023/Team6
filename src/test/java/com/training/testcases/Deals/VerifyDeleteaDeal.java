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
public class VerifyDeleteaDeal extends BaseTest {
    public void deletedeal() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());
        ExtentTestManager.getTest().pass("Logged in to application");
        BasePage.EntityPanel.Deals.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());

        // loginPage.checkPageHeader("Deals");

        DealsPage dealsPage = new DealsPage(getDriver());
        ExtentTestManager.getTest().pass("Delete a Deal");
        HashMap<String, String> sDealData = new HashMap<String, String>();
        String sDealName = CommonUtil.getRandomString("Training", 14);
        sDealData.put("Title", "nandini");
        sDealData.put("Assigned To", sDealName);
        sDealData.put("Company", sDealName);
        sDealData.put("Contacts", sDealName);
        sDealData.put("Close Date", sDealName);
        sDealData.put("Tags", sDealName);
        sDealData.put("Description", sDealName);
        sDealData.put("Probability", sDealName);
        sDealData.put("Amount", sDealName);
        sDealData.put("Commission", sDealName);
        sDealData.put("Status", sDealName);
        dealsPage.createDeals(sDealData);
        dealsPage.pageRefresh();
        dealsPage.selectEntity("Deals");
        //dealsPage.checkRecordDisplayed(sDealData.get("Title"));
        dealsPage.deleteDeal(sDealData);


    }
}

