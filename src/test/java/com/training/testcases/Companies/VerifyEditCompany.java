package com.training.testcases.Companies;

import com.training.pages.BasePage;
import com.training.pages.CompanyPage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.training.support.BrowserFactory.getDriver;
import static com.training.testcases.BaseTest.configurationDetails;

public class VerifyEditCompany extends BaseTest {

    @Test(description = "Login to application")
    public void editComapnyDts() throws Exception {

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
        map.put("source","Ad");
        companypage.createCompany(map);
        companypage.checkPageHeader(sCompanyName);
        ExtentTestManager.getTest().pass("Created Company." + sCompanyName);

        companypage.navigateToCompany();

        HashMap<String, String> updateDts = new HashMap<>();
        updateDts.put("edit_source", "Internet");

        companypage.editcompany(updateDts,sCompanyName);
        //Thread.sleep(5000);
        //Validate Edit is updating the details
        String sActualValue = companypage.getFieldValueFromView("Source");
        companypage.getFieldValueFromView("Source");


        Assert.assertTrue(sActualValue.contains("Internet"), "Details are not updated.Expected:".concat("Internet").concat(" Actual:").concat(sActualValue));

}

    private String randomIntGenerator(int len) {

        return RandomStringUtils.randomAlphanumeric(len);
    }
    }
