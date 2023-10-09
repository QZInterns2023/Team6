package com.training.testcases.Companies;

import com.training.pages.BasePage;
import com.training.pages.CompanyPage;
import com.training.pages.LoginPage;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import com.training.reporting.ExtentTestManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import java.util.HashMap;

@Test
public class VerifyAllFields extends BaseTest {


    //    private static final String TESTCASENAME = "TC01";
//
//    Map<String, Map<String, String>> sampleTestData;

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
        ExtentTestManager.getTest().pass("Company Created");
        HashMap<String, String> map = new HashMap<>();
        String s = CommonUtil.getRandomString("test", 10);
        map.put("Name", s);
        //map.put("Website", "www." + s + ".com");
        map.put("phone number", randomIntGenerator(10));
        map.put("email", s + ".com");
        map.put("Tags", "test_tag");
        map.put("description", s);
        map.put("industry", s);
        map.put("No.of Employees", randomIntGenerator(1));
        companypage.EnterCompanyDetails(map);
        ExtentTestManager.getTest().pass("entered company details successfully");
        companypage.savecompany();
        ExtentTestManager.getTest().pass("Company saved");
        companypage.checkPageHeader(s);
        //  companyflow.home();
        //  companyflow.verifycompany();
    }

    //    public String randomStringGenerator(int length){
//        return RandomStringUtils.randomAlphanumeric(length);
//    }
    public String randomIntGenerator(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }
}
//
//    }