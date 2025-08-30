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

    // Global By Locators
    private final By signInHeaderLink = By.xpath("//a[@id='SignInLink']");
    private final By signInSidebarLink = By.xpath("//a[contains(text(),'Sign In') and contains(@href,'/account/login')]");
    private final By shoppedWithUsBeforeModal = By.xpath("//h2[text()='Shopped with us before?']");
    private final By welcomeBackModal = By.xpath("//h2[contains(text(),'Welcome back!')]");
    private final By storeAddress = By.xpath("//div[@id='openFulfillmentModalButton']");
    private final By findAStoreModal = By.xpath("//h2[contains(text(),'Find a Store near you, or shop for Delivery or Pickup.')]");
    private final By zipCodeField = By.xpath("//*[@aria-labelledby='zipcode']");
    private final By searchIcon = By.xpath("//span[@aria-label='search Zipcode']");
    private final By deliveryTab = By.xpath("//a[@id='modal-tab-delivery-btn']");
    private final By shopButton = By.xpath("//a[text()=' Shop ']");
    private final By searchBox = By.xpath("//*[@name='q']");
    private final By searchButton = By.xpath("//*[@aria-label='search']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
    public WebElement getSignInHeaderLink() {
        return driver.findElement(signInHeaderLink);
    }

    public WebElement getSignInSidebarLink() {
        return driver.findElement(signInSidebarLink);
    }

    public WebElement getShoppedWithUsBeforeModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppedWithUsBeforeModal));
    }

    public WebElement getWelcomeBackModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackModal));
    }

    public WebElement getStoreAddress() {
        return driver.findElement(storeAddress);
    }

    public WebElement getFindAStoreModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(findAStoreModal));
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

    public WebElement getSearchButton() {
        return driver.findElement(searchButton);
    }

    // Public action methods
    public void clickSignInHeaderLink() {
        getSignInHeaderLink().click();
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

    public void clickSearchButton() {
        getSearchButton().click();
    }
    public void performSearch(String searchText) {
        getSearchBox().sendKeys(searchText);
        getSearchBox().submit(); // Simulates pressing Enter
    }


    public void waitForSearchBoxToBeInteractable() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
    }

}