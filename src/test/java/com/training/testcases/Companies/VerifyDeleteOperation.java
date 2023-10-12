package com.training.testcases.Companies;

import com.training.pages.BasePage;
import com.training.pages.CompanyPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.testng.annotations.Test;

import java.util.HashMap;

public class VerifyDeleteOperation extends BaseTest {

    @Test(description = "Login to application")
    public void deletecompany() throws Exception {

        //Map<String, String> testDetails = xlsFile.getExcelRowValuesIntoMapBasedOnKey("sampleSheet", TESTCASENAME);

        //Login to Application
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");
//        BasePage.EntityPanel.Companies.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Companies.toString());
        CompanyPage companypage = new CompanyPage(getDriver());
        String sCompanyName = CommonUtil.getRandomString("test", 5);
        HashMap<String, String> sCompanydata = new HashMap<>();
        sCompanydata.put("name",sCompanyName);
        sCompanydata.put("website",sCompanyName);
        sCompanydata.put("phone_no",sCompanyName);
        sCompanydata.put("email",sCompanyName);
        sCompanydata.put("description",sCompanyName);
        sCompanydata.put("industry",sCompanyName);
        sCompanydata.put("no_of_employees",sCompanyName);
        companypage.createCompany(sCompanydata);
        companypage.selectEntity("Companies");
        companypage.checkRecordDisplayed(sCompanyName);
        companypage.deletecompany(sCompanydata);
    }

}
