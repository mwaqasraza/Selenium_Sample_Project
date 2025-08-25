package com.digital.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='StoreAddress']")
    private WebElement storeAddress;

    @FindBy(xpath = "//*[@aria-labelledby='zipcode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//span[@aria-label='search Zipcode']")
    private WebElement searchIcon;

    @FindBy(xpath = "//a[@id='modal-tab-delivery-btn']")
    private WebElement deliveryTab;

    @FindBy(xpath = "//a[text()=' Shop ']")
    private WebElement shopButton;

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@aria-label='search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='openFulfillmentModalButton']")
    private WebElement openFulfillmentModalButton;

    @FindBy(xpath = "//a[@id='signIn']")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@id='sidebar-signIn']")
    private WebElement signInSidebarLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getStoreAddress() {
        return storeAddress;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getDeliveryTab() {
        return deliveryTab;
    }

    public WebElement getShopButton() {
        return shopButton;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getOpenFulfillmentModalButton() {
        return openFulfillmentModalButton;
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getSignInSidebarLink() {
        return signInSidebarLink;
    }

    public void enterZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);
    }

    public void clickSearchIcon() {
        searchIcon.click();
    }

    public void clickDeliveryTab() {
        deliveryTab.click();
    }

    public void clickShopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shopButton)).click();
    }

    public void enterSearchText(String searchText) {
        searchBox.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickStoreAddress(){
        openFulfillmentModalButton.click();
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickSignInSidebarLink() {
        signInSidebarLink.click();
    }

    public void pressEnterOnSearchBox() {
        searchBox.sendKeys("\n");
    }

    public void navigateToHomePage(String url){
        driver.get(url);
    }

}