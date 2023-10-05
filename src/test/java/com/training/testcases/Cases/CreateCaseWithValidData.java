package com.training.testcases.Cases;

import com.training.pages.BasePage;
import com.training.pages.CasePage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import com.training.utils.CommonUtil;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreateCaseWithValidData extends BaseTest {
    @Test
    public void createCase() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        loginPage.selectEntity(BasePage.EntityPanel.Companies.toString());
        ExtentTestManager.getTest().pass("Logged Into Application");

        CasePage casePage = new CasePage(getDriver());
        HashMap<String, String> map = new HashMap<>();
        String s = CommonUtil.getRandomString("auto", 5);
        map.put("Title", "production3");
        map.put("Description", s);
        map.put("Type", "Customer Support");
        map.put("Identifier", "s26@gmail.com ");
        map.put("Company", "Dell");
        map.put("Contact", "Swetha");
        map.put("Status", "Enquiring");
        map.put("Assigned To", "Swetha Putta");

        casePage.createCase(map);
    }
}