package com.training.pages;

import com.training.reporting.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.training.constants.ApplicationConstants;
import java.util.HashMap;

public class CompanyPage extends BasePage {
    public CompanyPage(WebDriver driver) {
        super(driver);
    }


    public static final By txt = By.name("name");
    private static By txtName = By.name("name");
    private static By txtWebsite = By.xpath("//input[@name='url']");
    private static By txtPhoneNo = By.xpath("//input[@placeholder='Number']");
    private static By txtEmail = By.xpath("//input[@placeholder='Email address']");
    private static By txtDescription = By.xpath("//textarea[@name='description']");
    private static By txtIndustry = By.xpath("//input[@name='industry']");
    private static By txtNoOfEmployees = By.xpath("//input[@name='num_employees']");


    public void navigateToCompany() {
        selectEntity("Companies");
    }

    public CompanyPage clickOnCreateButton() {
        createButton();
        return this;
    }

    public void enterCompanyDetails(HashMap<String , String> objCompanyData) throws InterruptedException {

        if (objCompanyData.containsKey("name")) {
            scriptAction.inputText(txtName,objCompanyData.get("name"));
        }
        if (objCompanyData.containsKey("edit_name")) {
            scriptAction.clearAndInputText(txtName,objCompanyData.get("edit_name"));
        }

        if (objCompanyData.containsKey("website")) {
            scriptAction.inputText(txtWebsite,objCompanyData.get("website"));
        }
        if(objCompanyData.containsKey("phone_no")){
            scriptAction.inputText(txtPhoneNo,objCompanyData.get("phone_no"));
        }

       // if (companies.containsKey())
        if (objCompanyData.containsKey("email")) {
            Thread.sleep(5000);
            scriptAction.clearAndInputText(txtEmail,objCompanyData.get("email"));
            Thread.sleep(5000);
        }

        if (objCompanyData.containsKey("description")) {
            scriptAction.inputText(txtDescription,objCompanyData.get("description"));
        }

        if (objCompanyData.containsKey("industry")) {
            scriptAction.inputText(txtIndustry,objCompanyData.get("industry"));
        }
        if (objCompanyData.containsKey("no_of_employees")) {
            scriptAction.inputText(txtNoOfEmployees,objCompanyData.get("no_of_employees"));
        }

        if (objCompanyData.containsKey("source")){
            selectItemFromDropdown("Source",objCompanyData.get("source"));
        }
        if (objCompanyData.containsKey("edit_source")) {
            selectItemFromDropdown("Source",objCompanyData.get("edit_source"));
        }

    }
    public CompanyPage Tags() {
        searchNSelectItemFromList("Tags","test_tag");
        return this;
    }

    public CompanyPage createCompany(HashMap<String , String> objCompanyData) throws InterruptedException {
        clickOnCreateButton();
        enterCompanyDetails(objCompanyData);
        clickOnSaveButton();
        return this;
    }
//    public CompanyPage companyBoundary(){
//        createCompany();
//        scriptActio.
//        errorMessagesBoundary(ApplicationConstants.errorMessageForLengthCompanies);
//    }

    public CompanyPage clickOnSaveButton() throws InterruptedException {
        saveButton();
        //scriptAction.waitUntilElementIsVisible( , ApplicationConstants.MEDIUM_TIMEOUT);
        return this;
    }

    /*public void deleteCompany(String sCompanyName) throws Exception {
        deleteRecord(sCompanyName,"Delete");

    }*/
    public CompanyPage editcompany(HashMap<String,String>objCompanyData,String sCompanyName) throws Exception{
        performTableOperation(sCompanyName,"edit");
        scriptAction.waitTillClickableAndClick(By.id("Source"), ApplicationConstants.MEDIUM_TIMEOUT);
        enterCompanyDetails(objCompanyData);
        clickOnSaveButton();
        return this;
    }
    public CompanyPage deletecompany(HashMap<String, String> data) throws Exception{
        navigateToCompany();
        performTableOperation(data.get("name"), "delete");
        //deleteRecord(delrec,"Delete");
        checkRecordNotDisplayed("sCompanydata");
        return this;
    }
}
