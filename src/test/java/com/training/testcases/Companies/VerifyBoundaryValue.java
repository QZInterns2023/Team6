package com.training.testcases.Companies;

import com.training.constants.ApplicationConstants;
import com.training.pages.BasePage;
import com.training.pages.CompanyPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.testng.annotations.Test;

import java.util.HashMap;

public class VerifyBoundaryValue extends BaseTest {
    @Test(description = "Login to application")
    public void createcompany() throws Exception {

        //Map<String, String> testDetails = xlsFile.getExcelRowValuesIntoMapBasedOnKey("sampleSheet", TESTCASENAME);

        //Login to Application
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");
        BasePage.EntityPanel.Companies.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Companies.toString());
        CompanyPage companypage = new CompanyPage(getDriver());
        //companypage.createcompany();
        ExtentTestManager.getTest().pass("Click on create Company");
        HashMap<String, String> map = new HashMap<>();
        String s = CommonUtil.getRandomString("test", 251);
        map.put("Name", s);
        companypage.enterCompanyDetails(map);
        ExtentTestManager.getTest().pass("Assign Company Data");
        //companypage.savecompany();
        ExtentTestManager.getTest().pass("Save Company");
        companypage.errorMessagesBoundary(ApplicationConstants.errorMessageForLengthCompanies);
    }
}