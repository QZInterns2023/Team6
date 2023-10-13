package com.training.testcases.Deals;

import com.training.constants.ApplicationConstants;
import com.training.pages.BasePage;
import com.training.pages.DealsPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.testng.annotations.Test;

import java.util.HashMap;





    public class VerifyBoundaryvalues extends BaseTest {
        @Test
        public void verifyBoundaryvalue() throws Exception {
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
            ExtentTestManager.getTest().pass("Boundary value");

            //Navigate
            loginPage.selectEntity(BasePage.EntityPanel.Deals.toString());
            //create a new task
            DealsPage dealsPage = new DealsPage(getDriver());
         //   dealsPage.clickonCreate();

            HashMap<String, String> deals = new HashMap<>();
            dealsPage.enterDealsDetails(deals);
            String s = CommonUtil.getRandomString("test", 351);
            deals.put("Title", s);
            deals.put("Description", "Complete it on time");
            deals.put("Completion", "20");
            deals.put("Identifier", "Not Yet completed");
            dealsPage.createDeals(deals);
          //  dealsPage.saveDetails();
            dealsPage.errorMessagesBoundary(ApplicationConstants.errorMessageForMandatoryFieldNameDeal);
        }
    }

