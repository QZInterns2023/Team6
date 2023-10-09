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
    public void companycreate() throws Exception {

        //Map<String, String> testDetails = xlsFile.getExcelRowValuesIntoMapBasedOnKey("sampleSheet", TESTCASENAME);

        //Login to Application
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");
        BasePage.EntityPanel.Companies.toString();
        loginPage.selectEntity(BasePage.EntityPanel.Companies.toString());
        CompanyPage companypage = new CompanyPage(getDriver());
        companypage.createcompany();
        HashMap<String, String> map = new HashMap<>();
        String s = CommonUtil.getRandomString("test", 5);
        //  map.put("Name",randomStringGenerator(8));
        map.put("Website","www." + s + ".com");
        map.put("phone number",randomIntGenerator(10));
        map.put("email",s+".com");
        map.put("Tags","test_tag");
        map.put("description",s);
        map.put("industry",s);
        map.put("No.of Employees",s);
        companypage.EnterCompanyDetails(map);
        companypage.savecompany();

        companypage.errorMessage(ApplicationConstants.errorMessageForMandatoryFieldNameCompany);
    }
    //    public String randomStringGenerator(int length){
//        return RandomStringUtils.randomAlphanumeric(length);
//    }
    public String randomIntGenerator(int len){
        return RandomStringUtils.randomAlphanumeric(len);
    }

}
