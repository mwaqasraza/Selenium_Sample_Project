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

    //Global By Locators
    private By signInLink = By.xpath("//button[@id='SignIn']");
    private By signInSidebarLink = By.xpath("//a[@id='side-nav-sign-in']");
    private By emailField = By.xpath("//input[@id='email']");
    private By signInWithPasswordButton = By.xpath("//button[contains(text(),'Sign in with password')]");
    private By storeAddress = By.xpath("//div[@id='openFulfillmentModalButton']");
    private By zipCodeField = By.xpath("//*[@aria-labelledby='zipcode']");
    private By searchIcon = By.xpath("//span[@aria-label='search Zipcode']");
    private By deliveryTab = By.xpath("//a[@id='modal-tab-delivery-btn']");
    private By shopButton = By.xpath("//a[text()=' Shop ']");
    private By searchBox = By.xpath("//*[@name='q']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //Getter Methods
    public WebElement getSignInLink() {
        return driver.findElement(signInLink);
    }

    public WebElement getSignInSidebarLink() {
        return driver.findElement(signInSidebarLink);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
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

    public WebElement getShopButton() {
        return driver.findElement(shopButton);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    //Action Methods
    public void clickSignInLink() {
        getSignInLink().click();
    }

    public void clickSignInSidebarLink() {
        getSignInSidebarLink().click();
    }

    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
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

    public void clickShopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(getShopButton())).click();
    }

    public void enterSearchText(String searchText) {
        getSearchBox().sendKeys(searchText);
    }
}