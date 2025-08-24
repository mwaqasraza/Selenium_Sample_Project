package com.digital.ui.pages;

// HomePage.java
//package com.safeway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Global By Locators
    private By signInLink = By.xpath("//*[@id=\"auth_signin_link\"]");
    private By signInSidebarLink = By.xpath("//*[@id=\"signin-dropdown\"]/div/div/div/div[1]/button"); // Updated xpath
    private By emailIdField = By.xpath("//input[@id='enterUsername']"); // Updated id
    private By passwordField = By.xpath("//input[@id=\"password\"]"); // Updated id
//    private By signInButton = By.xpath("//button[contains(text(), 'Sign in with password')]"); // Updated xpath
    private By signInButton = By.xpath("//button[contains(text(), ' Sign in without a password ')]"); // Updated xpath
    private By storeAddressLink = By.xpath("//div[@id='openFulfillmentModalButton']");
    private By zipCodeField = By.xpath("//*[@id=\"storeFulfillmentModal\"]/div/div/div[2]/store-fulfillment-tabs/div/div[1]/input");
    private By searchIcon = By.xpath("//*[@id=\"storeFulfillmentModal\"]/div/div/div[2]/store-fulfillment-tabs/div/div[1]/span");
    private By deliveryTab = By.xpath("//*[@id=\"modal-tab-delivery\"]");
    private By selectShopButton = By.xpath("//*[@id=\"fulfilmentDelivery\"]/div/div/store-card/div[2]/div/a");
    private By searchBox = By.xpath("//input[@id=\"skip-main-content\"]");
    private By broadwayAddressLink = By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div/div/div[3]/div/div/div[2]/global-header/div/div[2]/div[1]/secondary-bar/div[2]/div[1]/div[3]/span[1]");


    public HomePage(WebDriver driver) {
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
    public WebElement getSignInLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(signInLink));
    }

    public WebElement getSignInSidebarLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(signInSidebarLink));
    }

    public WebElement getEmailIdField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailIdField));
    }

    public WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
    }

    public WebElement getSignInButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    }

    public WebElement getStoreAddressLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(storeAddressLink));
    }

    public WebElement getZipCodeField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField));
    }

    public WebElement getSearchIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
    }

    public WebElement getDeliveryTab() {
        return wait.until(ExpectedConditions.elementToBeClickable(deliveryTab));
    }

    public WebElement getSelectShopButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(selectShopButton));
    }

    public WebElement getSearchBox() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
    }
    public WebElement getBroadwayAddressLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(broadwayAddressLink));
    }


    // Public action methods
    public void clickSignInLink() {
        getSignInLink().click();
    }

    public void clickSignInSidebarLink() {
        getSignInSidebarLink().click();
    }

    public void enterEmailId(String email) {
        getEmailIdField().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

    public void clickStoreAddressLink() {
        getStoreAddressLink().click();
    }

    public void enterZipCode(String zipCode) {
        getZipCodeField().sendKeys(zipCode);
    }

    public void clickSearchIcon() {
        getSearchIcon().click();
    }

    public void clickDeliveryTab() {
        getDeliveryTab().click();
    }

    public void clickSelectShopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selectShopButton)).click();
    }

    public void enterSearchText(String text) {
        getSearchBox().sendKeys(text);
    }

    public void clickBroadwayAddressLink() {
        getBroadwayAddressLink().click();
    }
}