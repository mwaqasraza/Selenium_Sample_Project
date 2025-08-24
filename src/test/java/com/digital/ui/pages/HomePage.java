package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By signInLink = By.xpath("//a[@id='SignIn']");
    private final By signInSidebarLink = By.xpath("//a[@data-qa='link-sign-in']"); //Updated Locator
    private final By shoppedWithUsBeforeModal = By.xpath("//h2[text()='Shopped with us before?']");
    private final By welcomeBackModal = By.xpath("//h2[contains(text(),'Welcome back!')]");
    private final By storeAddress = By.xpath("//div[@id='openFulfillmentModalButton']");
    private final By zipCodeField = By.xpath("//*[@aria-labelledby='zipcode']");
    private final By searchIcon = By.xpath("//span[@aria-label='search Zipcode']");
    private final By deliveryTab = By.xpath("//a[@id='modal-tab-delivery-btn']");
    private final By shopButton = By.xpath("//a[text()=' Shop ']");
    private final By searchBox = By.xpath("//*[@name='q']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // Getters for WebElements

    public WebElement getSignInLink() {
        return driver.findElement(signInLink);
    }

    public WebElement getShoppedWithUsBeforeModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppedWithUsBeforeModal));
    }

     public WebElement getWelcomeBackModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackModal));
    }

    public WebElement getSignInSidebarLink() {
        return driver.findElement(signInSidebarLink);
    }

    public WebElement getStoreAddress() {
        return driver.findElement(storeAddress);
    }

    public WebElement getZipCodeField() {
        return driver.findElement(zipCodeField);
    }

    public WebElement getSearchIcon() {
        return driver.findElement(searchIcon);
    }

    public WebElement getDeliveryTab() {
        return driver.findElement(deliveryTab);
    }

    public WebElement getShopButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(shopButton));
    }

      public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }


    // Action Methods
    public void clickSignInLink() {
        getSignInLink().click();
    }

    public void clickSignInSidebarLink() {
        getSignInSidebarLink().click();
    }

    public void clickStoreAddress() {
        getStoreAddress().click();
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

    public void clickShopButton() {
        getShopButton().click();
    }

     public void enterSearchText(String searchText) {
        getSearchBox().sendKeys(searchText);
    }

    public void clearSearchBox(){
        getSearchBox().clear();
    }

     public void submitSearchText(String searchText) {
        getSearchBox().sendKeys(searchText + "\n");
    }

}