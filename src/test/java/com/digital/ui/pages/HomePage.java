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
    private By signInLink = By.xpath("//a[contains(text(),'Sign In')]");
    private By signInSidebarLink = By.xpath("//a[contains(text(),'Sign in')]");
    private By shopperModalTitle = By.xpath("//h2[contains(text(),'Shopped with us before?')]");
    private By welcomeBackModalTitle = By.xpath("//h2[contains(text(),'Welcome back!')]");
    private By emailField = By.id("email");
    private By signInWithPasswordButton = By.xpath("//button[contains(text(),'Sign in with password')]");
    private By storeAddress = By.xpath("//div[@id='openFulfillmentModalButton']");
    private By findAStoreModalTitle = By.xpath("//h2[contains(text(),'Find a Store near you, or shop for Delivery or Pickup.')]");
    private By zipCodeField = By.xpath("//*[@aria-labelledby='zipcode']");
    private By searchIcon = By.xpath("//span[@aria-label='search Zipcode']");
    private By deliveryTab = By.xpath("//a[@id='modal-tab-delivery-btn']");
    private By shopButton = By.xpath("//a[text()=' Shop ']");
    private By searchBox = By.xpath("//*[@name='q']");
    private By cartIcon = By.xpath("//div[@id='cart-icon']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters for WebElements
    public WebElement getSignInLink() {
        return driver.findElement(signInLink);
    }

    public WebElement getSignInSidebarLink() {
        return driver.findElement(signInSidebarLink);
    }

    public WebElement getShopperModalTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shopperModalTitle));
    }

    public WebElement getWelcomeBackModalTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackModalTitle));
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
    public WebElement getFindAStoreModalTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(findAStoreModalTitle));
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
    public WebElement getCartIcon() {
        return driver.findElement(cartIcon);
    }

    // Action Methods
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
        getShopButton().click();
    }

    public void enterSearchText(String searchText) {
        getSearchBox().sendKeys(searchText);
    }
    public void clickCartIcon() {
        getCartIcon().click();
    }

}