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
    public void companyboundaryValue() throws Exception {

        //Map<String, String> testDetails = xlsFile.getExcelRowValuesIntoMapBasedOnKey("sampleSheet", TESTCASENAME);

        //Login to Application
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");
        //BasePage.EntityPanel.Companies.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Companies.toString());
        CompanyPage companypage = new CompanyPage(getDriver());
        //companypage.createcompany();
        ExtentTestManager.getTest().pass("Click on create Company");
        HashMap<String, String> map = new HashMap<>();
        String sCompanyData = CommonUtil.getRandomString("test", 400);
        map.put("name", sCompanyData);
       // companypage.createCompany(map);
        ExtentTestManager.getTest().pass("Entered company details");
        ExtentTestManager.getTest().pass("Assign Company Data");
        ExtentTestManager.getTest().pass("Save Company");
        companypage.createCompany(map);
        //Thread.sleep(2000);
        companypage.errorMessagesBoundary(ApplicationConstants.errorMessageForLengthCompanies);
    }
}