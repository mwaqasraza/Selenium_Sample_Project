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
    private final By signInHeaderLink = By.xpath("//a[text()='Sign In']");
    private final By signInSidebarLink = By.xpath("//a[contains(text(),'Sign In')]");
    private final By emailField = By.xpath("//input[@id='email']");
    private final By signInWithPasswordButton = By.xpath("//button[contains(text(),'Sign in with Password')]");
    private final By storeAddress = By.xpath("//div[@id='openFulfillmentModalButton']");
    private final By zipCodeField = By.xpath("//*[@aria-labelledby='zipcode']");
    private final By searchIcon = By.xpath("//span[@aria-label='search Zipcode']");
    private final By deliveryTab = By.xpath("//a[@id='modal-tab-delivery-btn']");
    private final By selectShopButton = By.xpath("//a[text()=' Shop ']");
    private final By searchBox = By.xpath("//*[@name='q']");
    private final By searchButton = By.xpath("//*[@aria-label='search']");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getter methods for WebElements
    public WebElement getSignInHeaderLink() {
        return driver.findElement(signInHeaderLink);
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

    public WebElement getSelectShopButton() {
        return driver.findElement(selectShopButton);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement getSearchButton() {
        return driver.findElement(searchButton);
    }

    //Action Methods
    public void clickSignInHeaderLink() {
        getSignInHeaderLink().click();
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

    public void clickSelectShopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(getSelectShopButton())).click();
    }

    public void enterSearchText(String searchText) {
        getSearchBox().sendKeys(searchText);
        getSearchButton().click();
    }

    public void enterSearchTextAndPressEnter(String searchText) {
        getSearchBox().sendKeys(searchText);
        getSearchBox().sendKeys("\n");  //Simulates pressing the Enter key
    }


    public void waitUntilSearchFieldIsInteractable() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
    }


    public void waitUntilStoreModalIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Find a Store near you')]")));
    }

    public void waitUntilWelcomeBackModalIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Welcome back!')]")));
    }

    public void waitUntilShoppedWithUsBeforeModalIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Shopped with us before?')]")));
    }
}