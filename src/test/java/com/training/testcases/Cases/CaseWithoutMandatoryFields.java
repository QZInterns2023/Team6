package com.training.testcases.Cases;

import com.training.pages.CasePage;
import com.training.pages.LoginPage;
import com.training.reporting.ExtentTestManager;
import com.training.testcases.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.training.constants.ApplicationConstants.errorMessageForMandatoryFieldNameCases;

public class CaseWithoutMandatoryFields extends BaseTest {
    @Test
    public void checkErrormsg() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToApplication(configurationDetails.getUserName(), configurationDetails.getPassword());
        CasePage casePage = new CasePage(getDriver());
        casePage.navigateToCases();
        casePage.clickCases();
        HashMap<String, String> map = new HashMap<>();
        map.put("Title", "");
        casePage.enterCaseDetails(map);
        casePage.save();
        casePage.errorMessage(errorMessageForMandatoryFieldNameCases);
    }
}