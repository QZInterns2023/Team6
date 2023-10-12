package com.training.testcases.Companies;

import com.training.constants.ApplicationConstants;
import com.training.pages.BasePage;
import com.training.pages.CompanyPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.training.support.BrowserFactory.getDriver;
import static com.training.testcases.BaseTest.configurationDetails;

public class VerifyMandatoryFields extends BaseTest {

    @Test(description = "Login to application")
    public void verifyCompanyMandatoryFields() throws Exception {

        //Map<String, String> testDetails = xlsFile.getExcelRowValuesIntoMapBasedOnKey("sampleSheet", TESTCASENAME);

        //Login to Application
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");
        BasePage.EntityPanel.Companies.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Companies.toString());
        CompanyPage companypage = new CompanyPage(getDriver());
        HashMap<String, String> companyData = new HashMap<>();
        String sCompanydetails = CommonUtil.getRandomString("test", 5);
        //  map.put("Name",randomStringGenerator(8));
        companyData.put("Website","www." + sCompanydetails  + ".com");
        companyData.put("phone number",randomIntGenerator(10));
        companyData.put("email",sCompanydetails +".com");
        companyData.put("Tags","test_tag");
        companyData.put("description",sCompanydetails );
        companyData.put("industry",sCompanydetails );
        companyData.put("No.of Employees",sCompanydetails );
        companypage.createCompany(companyData);
        ExtentTestManager.getTest().pass("Navigate to company home page");
        ExtentTestManager.getTest().pass("Click on new company page");
        ExtentTestManager.getTest().pass("Entered company details");
        ExtentTestManager.getTest().pass("Created Company." + sCompanydetails);
        companypage.errorMessage(ApplicationConstants.errorMessageForMandatoryFieldNameCompany);
    }
    //    public String randomStringGenerator(int length){
//        return RandomStringUtils.randomAlphanumeric(length);
//    }
    public String randomIntGenerator(int len){
        return RandomStringUtils.randomAlphanumeric(len);
    }

}
