package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class CompanyPage extends BasePage {
    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    public static final By createcompany = By.xpath("//button[@class='ui linkedin button']//i[@class='edit icon']/ancestor::button");

    public static final By txt = By.name("name");
//    public static final delrec =

    public CompanyPage createcompany() {
        createButton();
        return this;
    }

    public void EnterCompanyDetails(HashMap<String , String> companies) throws InterruptedException {

        if (companies.containsKey("Name")) {
            scriptAction.inputText(By.xpath("//input[@name='name'])[1]"),companies.get("Name"));

        }


        if (companies.containsKey("website")) {

            scriptAction.inputText(By.xpath("//input[@name=\"url\"]"),companies.get("website"));

        }

        if (companies.containsKey("phone no")) {

            scriptAction.inputText(By.xpath("(//input[@name=\"value\"])[1]"),companies.get("phone no"));

        }
        if (companies.containsKey("email")) {

            scriptAction.inputText(By.xpath("//input[@placeholder=\"Email address\"]"),companies.get("email"));

        }
//        if (companies.containsKey("Tags")) {
//
//           Tags();
//
//        }

        if (companies.containsKey("description")) {

            scriptAction.inputText(By.xpath("//textarea[@name='description']"),companies.get("description"));

        }

        if (companies.containsKey("industry")) {

            scriptAction.inputText(By.xpath("//input[@name=\"industry\"]"),companies.get("industry"));

        }
        if (companies.containsKey("No.of Employees")) {

            scriptAction.inputText(By.xpath("//input[@name=\"num_employees\"]"),companies.get("No.of Employees"));

        }

    }
    public CompanyPage Tags() {
        searchNSelectItemFromList("Tags","test_tag");
        return this;
    }

    public CompanyPage savecompany() throws InterruptedException {
        saveButton();

        // scriptAction.waitTillClickableAndClick(By.name("Save"), ApplicationConstants.SHORT_TIMEOUT);

        return this;
    }
//    public Companyflow verifyerrormsg(){
//        errorMessage("The field Name is required");
//        scriptAction.waitTillClickableAndClick(By.xpath("//span[@class='inline-error-msg"), ApplicationConstants.SHORT_TIMEOUT);
//        return this;
//    }
//    public Companyflow home() throws InterruptedException {
//        selectEntity("Companies");
//        return this;
//
//    }

    public CompanyPage verifycompany() throws Exception {
        // checkRecordDisplayed(s);
        return this;
    }
    public void deleteCompany(HashMap<String,String> map) throws Exception {
        selectEntity("Companies");
        pageRefresh();
        checkRecordDisplayed(map.get("Name"));
        performTableOperation(map.get("Name"), "Delete");
        performActionsOnPopUp("Delete");
        pageRefresh();
        checkRecordNotDisplayed(map.get("Name"));
    }
}
