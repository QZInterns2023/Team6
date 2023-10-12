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
    public void createcompany() throws Exception {

         //Login to Application
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged in to application");

        CompanyPage companypage = new CompanyPage(getDriver());
        companypage.navigateToCompany();;
        ExtentTestManager.getTest().pass("Navigate to company home page");


        HashMap<String, String> map = new HashMap<>();
        String sCompanyName = CommonUtil.getRandomString("test", 10);
        map.put("name", sCompanyName);
        //map.put("Website", "www." + s + ".com");

        map.put("phone_no", randomIntGenerator(10));
        map.put("email", sCompanyName + "@gmail.com");
        map.put("description", "New Company");
        map.put("industry", "IT");
        map.put("no_of_employees", randomIntGenerator(1));
        companypage.createCompany(map);
        ExtentTestManager.getTest().pass("Click on new company page");
        ExtentTestManager.getTest().pass("Entered company details");
        ExtentTestManager.getTest().pass("Created Company." + sCompanyName);
        companypage.checkPageHeader(sCompanyName);
        ExtentTestManager.getTest().pass("verify company saved");

    }

    public String randomIntGenerator(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }
}
//
//    }