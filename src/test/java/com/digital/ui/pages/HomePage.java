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
    private final By signInHeaderLink = By.xpath("//a[@id='globalSignIn']");
    private final By signInSidebarLink = By.xpath("//a[contains(text(),'Sign In')]");
    private final By emailIdField = By.xpath("//input[@id='j_username']");
    private final By signInWithPasswordButton = By.xpath("//button[contains(text(),'Sign in with password')]");
    private final By storeAddress = By.xpath("//div[@id='openFulfillmentModalButton']");
    private final By zipCodeField = By.xpath("//*[@aria-labelledby='zipcode']");
    private final By searchIcon = By.xpath("//span[@aria-label='search Zipcode']");
    private final By deliveryTab = By.xpath("//a[@id='modal-tab-delivery-btn']");
    private final By selectShopButton = By.xpath("//a[text()=' Shop ']");
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

    public WebElement getEmailIdField() {
        return driver.findElement(emailIdField);
    }

    public WebElement getSignInWithPasswordButton() {
        return driver.findElement(signInWithPasswordButton);
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

    public WebElement getSelectShopButton() {
        return driver.findElement(selectShopButton);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement getSearchButton() {
        return driver.findElement(searchButton);
    }

    // Public action methods for page related actions
    public void clickSignInHeaderLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signInHeaderLink)).click();
    }

    public void clickSignInSidebarLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signInSidebarLink)).click();
    }

    public void enterEmailId(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailIdField)).sendKeys(email);
    }

    public void clickSignInWithPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInWithPasswordButton)).click();
    }

    public void clickStoreAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(storeAddress)).click();
    }

    public void enterZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(zipCode);
    }

    public void clickSearchIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
    }

    public void clickDeliveryTab() {
        wait.until(ExpectedConditions.elementToBeClickable(deliveryTab)).click();
    }

    public void clickSelectShopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selectShopButton)).click();
    }

    public void enterSearchText(String searchText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(searchText);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}