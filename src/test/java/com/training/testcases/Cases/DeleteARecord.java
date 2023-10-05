package com.training.testcases.Cases;

import com.training.pages.BasePage;
import com.training.pages.CasePage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DeleteARecord extends BaseTest {
    @Test
    public void Delete() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        ExtentTestManager.getTest().pass("Logged Into Application");
        CasePage casePage = new CasePage(getDriver());

        HashMap<String, String> map = new HashMap<>();
        map.put("Title", "nandu");
        map.put("Description", "Sample");
        map.put("Type", "Customer Support");

        casePage.createCase(map);
        casePage.Remove(map);
    }
}