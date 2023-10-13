package com.training.pages;

import com.training.constants.ApplicationConstants;
import com.training.reporting.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class DealsPage extends BasePage {
    public DealsPage(WebDriver driver) {

        super(driver);
    }

    private static final By btnCreate = By.xpath("//i[@class='edit icon']//parent::button[@class='ui linkedin button']");
    private static final By txtName = By.xpath("//input[@name=\'title\']");

    String titleName = "//input[@name = 'title' ]";

    String xpath_amount = "//input[@name=\'amount\']";
    String xpath_company = "//input[@aria-autocomplete=\'list\']//parent::div[@name=\'company\']";

    String xpath_probability = "//input[@name=\'probability\']";
    String xpath_commission = "//input[@name='commission']";
    String xpath_description = "//textarea[@name=\'description\']";

    public void navigateToDeal() {
        selectEntity(EntityPanel.Deals.toString());
    }
    public DealsPage clickonCreateButton() {
        createButton();
        //scriptAction.waitUntilElementIsVisible(txtName, ApplicationConstants.MEDIUM_TIMEOUT, "Create a Deals page is not displayed");
        return this;
    }

    public void enterDealsDetails(HashMap<String, String> objDealsData) throws InterruptedException {
        Thread.sleep(5000);
        if (objDealsData.containsKey("Title")) {
           // scriptAction.waitUntilElementIsVisible(By.xpath("//input[@type='text' and @name = 'title' ]"), ApplicationConstants.SHORT_TIMEOUT);
            scriptAction.clearAndInputText(By.xpath(titleName),objDealsData.get("Title"));
        }
        if (objDealsData.containsKey("edit_name")) {
            // scriptAction.waitUntilElementIsVisible(By.xpath("//input[@type='text' and @name = 'title' ]"), ApplicationConstants.SHORT_TIMEOUT);
            scriptAction.clearAndInputText(By.xpath(titleName),objDealsData.get("edit_name"));
        }


        if (objDealsData.containsKey("Close Date")) {
            scriptAction.clearAndInputText(By.className("calendarField"), objDealsData.get("Close Date"));
        }
        if (objDealsData.containsKey("Description")) {
            scriptAction.clearAndInputText(By.xpath(xpath_description), objDealsData.get("Description"));
        }
        if (objDealsData.containsKey("Amount")) {
            scriptAction.clearAndInputText(By.xpath(xpath_amount), objDealsData.get("Amount"));
        }


        if (objDealsData.containsKey("Probability")) {
            scriptAction.clearAndInputText(By.xpath(xpath_probability), objDealsData.get("Probability"));
        }
        if (objDealsData.containsKey("source")){
            selectItemFromDropdown("Source",objDealsData.get("source"));
        }
        if (objDealsData.containsKey("edit_source")) {
            selectItemFromDropdown("Source",objDealsData.get("edit_source"));
        }

        if (objDealsData.containsKey("Commission")) {
            scriptAction.clearAndInputText(By.xpath(xpath_commission), objDealsData.get("Commission"));
        }
      //  if (objDealsData.containsKey("Company")) searchNSelectItemFromList("Company", "qualizeal");
          if (objDealsData.containsKey("Contacts")) searchNSelectItemFromList("Contacts", "Bharat Bharath");
//          if (objDealsData.containsKey("Tags")) searchNSelectItemFromList("Tags", "Its service2");
//        if (objDealsData.containsKey("Assigned To")) selectItemFromDropdown("Assigned To", "werwer werwer");
        if (objDealsData.containsKey("Stage")) selectItemFromDropdown("Stage", "Prospect");
        if (objDealsData.containsKey("Status")) selectItemFromDropdown("Status", "Active");
}

    public DealsPage Tags() {
        searchNSelectItemFromList("Tags","Its a google website");
        return this;
    }

    public DealsPage createDeals(HashMap<String, String>objDealsData) throws Exception {
        clickonCreateButton();
        enterDealsDetails(objDealsData);
        clickOnSaveButton();
        return this;
    }

    public DealsPage clickOnSaveButton() {
        saveButton();
        return this;
    }

    public void deleteDeal(HashMap<String, String>data) throws Exception{
        navigateToDeal();
        //deleteRecord(sDealName,"Delete");
        performTableOperation(data.get("Title"), "delete");
        performActionsOnPopUp("Delete");
        checkRecordNotDisplayed("sDealData");
    }

    public DealsPage editDeal(HashMap<String,String>objDealsData,String sCompanyName) throws Exception{
        performTableOperation(sCompanyName,"edit");
        //scriptAction.waitTillClickableAndClick(By.id("Source"), ApplicationConstants.MEDIUM_TIMEOUT);
        enterDealsDetails(objDealsData);
        clickOnSaveButton();
        return this;

    }

    }




