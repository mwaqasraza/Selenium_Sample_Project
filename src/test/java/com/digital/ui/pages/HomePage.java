package com.digital.ui.pages;

// HomePage.java
package com.nisum.pages;

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
    private By signInHeaderLink = By.xpath("//a[contains(text(),'Sign In')]");
    private By shoppedBeforeModal = By.xpath("//h2[contains(text(),'Shopped with us before?')]");
    private By signInSidebarLink = By.xpath("//a[contains(text(),'Sign In')]");
    private By welcomeBackModal = By.xpath("//h2[contains(text(),'Welcome back!')]");
    private By emailIdField = By.xpath("//input[@id='label-email']");
    private By signInWithPasswordButton = By.xpath("//button[contains(text(),'Sign in with password')]");
    private By storeAddress = By.xpath("//div[@id='openFulfillmentModalButton']");
    private By findStoreModal = By.xpath("//h2[contains(text(),'Find a Store near you')]");
    private By zipCodeField = By.xpath("//*[@aria-labelledby='zipcode']");
    private By searchIcon = By.xpath("//span[@aria-label='search Zipcode']");
    private By deliveryTab = By.xpath("//a[@id='modal-tab-delivery-btn']");
    private By selectShopButton = By.xpath("//a[text()=' Shop ']");
    private By searchBox = By.xpath("//*[@name='q']");
    private By searchButton = By.xpath("//*[@aria-label='search']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
    public WebElement getSignInHeaderLink() {
        return driver.findElement(signInHeaderLink);
    }

    public WebElement getShoppedBeforeModal() {
        return driver.findElement(shoppedBeforeModal);
    }

    public WebElement getSignInSidebarLink() {
        return driver.findElement(signInSidebarLink);
    }

    public WebElement getWelcomeBackModal() {
        return driver.findElement(welcomeBackModal);
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

    public WebElement getFindStoreModal() {
        return driver.findElement(findStoreModal);
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
        getSignInHeaderLink().click();
    }

    public void clickSignInSidebarLink() {
        getSignInSidebarLink().click();
    }

    public void enterEmailId(String email) {
        getEmailIdField().sendKeys(email);
    }

    public void clickSignInWithPasswordButton() {
        getSignInWithPasswordButton().click();
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

    public void clickSelectShopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selectShopButton));
        getSelectShopButton().click();
    }

    public void enterSearchText(String searchText) {
        getSearchBox().sendKeys(searchText);
    }

    public void clickSearchButton() {
        getSearchButton().click();
    }
}