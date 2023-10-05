package com.training.pages;

import com.training.constants.ApplicationConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class CasePage extends BasePage {

    public CasePage(WebDriver driver) {
        super(driver);
    }

    private static final By btnCreate = By.xpath("//button[contains(text(),\"Create\")]");
    public final By txtTitle = By.xpath("//input[@name='title']");
    public final By txtDescription = By.xpath("//textarea[@name='description']");
    public final By txtType = By.xpath("//div[@name='type' and @role='listbox']");
    public final By txtIdentifier = By.xpath("//input[@name='identifier']");
    public final By txtSave = By.xpath("//button[@class='ui linkedin button']");

    public void navigateToCases() {
        selectEntity(EntityPanel.Cases.toString());
    }

    public CasePage clickCases() {
       navigateToCases();
        scriptAction.waitUntilElementIsVisible(btnCreate, ApplicationConstants.SHORT_TIMEOUT);
        scriptAction.clickElement(btnCreate);
        return this;
    }


    public CasePage save() throws InterruptedException {
        saveButton();
        scriptAction.waitTillClickableAndClick(By.name("Save"),ApplicationConstants.SHORT_TIMEOUT);
        return this;
    }
//    public CasePage Verify() throws Exception {
//        checkRecordDisplayed("production3");
//        return this;
//    }
    public CasePage enterCaseDetails(HashMap<String, String> caseDetails) throws InterruptedException {
        navigateToCases();
        clickCases();
        if (caseDetails.containsKey("Title")) {
            scriptAction.inputText(txtTitle, caseDetails.get("Title"));
        }
        if (caseDetails.containsKey("Description")) {
            scriptAction.inputText(txtDescription, caseDetails.get("Description"));
        }
        if (caseDetails.containsKey("Type")) {
            scriptAction.clickElement(txtType);
            scriptAction.clickElement(By.xpath("//span[normalize-space()='" + caseDetails.get("Type") + "']"));
        }
        if (caseDetails.containsKey("Identifier")) {
            scriptAction.inputText(txtIdentifier, caseDetails.get("Identifier"));
        }
        if (caseDetails.containsKey("Company")) {
            searchNSelectItemFromList("Company", caseDetails.get("Company"));
        }
        if (caseDetails.containsKey("Contact")) {
            searchNSelectItemFromList("Contact", caseDetails.get("Contact"));
        }
        if (caseDetails.containsKey("Status")) {
            selectItemFromDropdown("Status", caseDetails.get("Status"));
        }
        if (caseDetails.containsKey("Assigned To")) {
            selectItemFromDropdown("Assigned To", caseDetails.get("Assigned To"));
            scriptAction.waitTillClickableAndClick(By.name("Assigned To"),ApplicationConstants.SHORT_TIMEOUT);
        }
        return this;


    }
    public CasePage  createCase(HashMap<String, String> Details) throws Exception {
       // navigateToCases();
        clickCases();
        enterCaseDetails(Details);
        save();
        //checkPageHeader(Details.get("Title"));
       // checkRecordDisplayed(Details.get("Title"));

        return this;
    }

    public CasePage Remove(HashMap<String, String> Details) throws Exception {navigateToCases();
     performTableOperation(Details.get("Title"),"delete");
     performActionsOnPopUp("Delete");
     //checkRecordNotDisplayed("nandu");
     return this;
    }
}