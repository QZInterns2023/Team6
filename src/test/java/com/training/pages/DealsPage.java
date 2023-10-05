package com.training.pages;

import com.training.constants.ApplicationConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class DealsPage extends BasePage {
    public DealsPage(WebDriver driver) {

        super(driver);
    }

    private static final By btnCreate = By.xpath("//i[@class='edit icon']//parent::button[@class='ui linkedin button']");
    private static final By txtName = By.xpath("//input[@name=\'title\']");

    String xpath_titleName = "//input[@name='title']";

    String xpath_amount = "//input[@name=\'amount\']";
    String xpath_company = "//input[@aria-autocomplete=\'list\']//parent::div[@name=\'company\']";
    // String xpath_contacts = "//div[@name=\"contacts\"]";
    String xpath_probability = "//input[@name=\'probability\']";
    String xpath_commission = "//input[@name='commission']";
    String xpath_description = "//textarea[@name=\'description\']";


    public DealsPage clickonCreate() {
        createButton();
        /*scriptAction.clickElement(btnCreate);
        scriptAction.waitUntilElementIsVisible(By.xpath(xpath_titleName), ApplicationConstants.MEDIUM_TIMEOUT, "create a deals page is not displayed");*/
        return this;
    }

//    public Dealspage crtDeal(HashMap<String, String> deals, String pageHeadderVerification) throws Exception {
//        checkPageHeader("Create new Deal");
//        pageRefresh();
//        Thread.sleep(3000);
//        dealsDetails(deals);
////        saveButton();
//        if (pageHeadderVerification.equals(true)) checkPageHeader(deals.get("Title"));
//        Thread.sleep(5000);
//        selectEntity("Deals");
//        pageRefresh();
//        recordVerification(deals.get("Title"), true);
//        return this;
//    }


    public void enterDetails(HashMap<String, String> deals) throws InterruptedException {
        Thread.sleep(5000);
        if (deals.containsKey("Title")) {
            scriptAction.waitUntilElementIsVisible(By.name("title"), ApplicationConstants.SHORT_TIMEOUT);
            scriptAction.clearAndInputText(By.name("title"), deals.get("Title"));
        }

        if (deals.containsKey("Close Date")) {
            scriptAction.inputText(By.className("calendarField"), deals.get("Close Date"));
        }
        if (deals.containsKey("Description")) {
            scriptAction.inputText(By.xpath(xpath_description), deals.get("Description"));
        }
        if (deals.containsKey("Amount")) {
            scriptAction.inputText(By.xpath(xpath_amount), deals.get("Amount"));
        }


        if (deals.containsKey("Probability")) {
            scriptAction.inputText(By.xpath(xpath_probability), deals.get("Probability"));
        }


        if (deals.containsKey("Commission")) {
            scriptAction.inputText(By.xpath(xpath_commission), deals.get("Commission"));
        }
        if (deals.containsKey("Company")) searchNSelectItemFromList("Company", "qualizeal");
        if (deals.containsKey("Contacts")) searchNSelectItemFromList("Contacts", "Bharat");
     //  if (deals.containsKey("Tags")) searchNSelectItemFromList("Tags", "Its service2");
        if (deals.containsKey("Assigned To")) selectItemFromDropdown("Assigned To", "werwer werwer");
        if (deals.containsKey("Stage")) selectItemFromDropdown("Stage", "Prospect");
        if (deals.containsKey("Status")) selectItemFromDropdown("Status", "Active");


    }
    public DealsPage saveDetails() {
        saveButton();
        return this;
    }
    public DealsPage error(){
        errorMessage("The field Title is required.");
        return this;
    }

//     public DealsPage homePage() {
//      homePage();
//        return this;
//   }
//    public void verify() {
//        String a = "//span[@class='selectable ']";
//        //scriptAction.waitUntilElementIsVisible(By.xpath("//a[text()=\"Deals1\"]"), ApplicationConstants.SHORT_TIMEOUT);
//        checkPageHeader("");
//        //return this;
    }
//
//    public DealsPage viewRecord(HashMap<String, String> mapViewData) throws Exception {
//        pageRefresh();
//        checkRecordDisplayed(mapViewData.get("Title"));
//        performTableOperation(mapViewData.get("Title"),"View");
//        checkPageHeader(mapViewData.get("Title"));
//        return this;
//    }
//
//    public DealsPage editRecord(HashMap<String, String> mapEditData) throws Exception {
//        pageRefresh();
//        //Thread.sleep(5000);
//        selectEntity("Deals");
//        checkRecordDisplayed(mapEditData.get("Title"));
//        performTableOperation(mapEditData.get("Title"),"Edit");
//        enterDetails(mapEditData);
//        saveButton();
//        checkPageHeader(mapEditData.get("Title"));
//        return this;
//    }
//    public DealsPage deleteRecord(HashMap<String, String> mapDeleteRecord) throws Exception {
//
//        selectEntity("Deals");
//        pageRefresh();
////        checkRecordDisplayed(mapDeleteRecord.get("Title"));
//        // performTableOperation(mapDeleteRecord.get("Title"),"Delete");
//        deleteRecord(mapDeleteRecord.get("Title"),"Delete");
//        checkRecordNotDisplayed(mapDeleteRecord.get("Title"));
//        //scriptAction.waitUntilElementIsVisible(By.name(mapDeleteRecord.get("Title")),ApplicationConstants.MEDIUM_TIMEOUT);
//        checkPageHeader("Deals");
//        return this;
//    }
//


