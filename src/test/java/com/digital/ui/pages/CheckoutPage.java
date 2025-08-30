package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By firstNameField = By.xpath("//input[@name='firstName']");
    private final By lastNameField = By.xpath("//input[@id='lastName']");
    private final By streetAddressField = By.xpath("//input[@id='streetAddress']");
    private final By zipCodeField = By.xpath("//input[@id='zipCode']");
    private final By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private final By fastestDeliveryTime = By.xpath("//div[@class='delivery-time-slot'][1]//input[@type='radio']"); // Example - may need adjustment
    private final By orderInfoPageLocator = By.xpath("//h1[contains(text(), 'Checkout')]");  //Example , adjust as needed.

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters
    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }

    public WebElement getStreetAddressField() {
        return driver.findElement(streetAddressField);
    }

    public WebElement getZipCodeField() {
        return driver.findElement(zipCodeField);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }
    public WebElement getFastestDeliveryTime(){return driver.findElement(fastestDeliveryTime);}
    public WebElement getOrderInfoPageElement(){return wait.until(ExpectedConditions.visibilityOfElementLocated(orderInfoPageLocator));}


    // Actions
    public void enterFirstName(String firstName) {
        getFirstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameField().sendKeys(lastName);
    }

    public void enterStreetAddress(String streetAddress) {
        getStreetAddressField().sendKeys(streetAddress);
    }

    public void enterZipCode(String zipCode) {
        getZipCodeField().sendKeys(zipCode);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }
    public void clickFastestDeliveryTime(){getFastestDeliveryTime().click();}

    public void fillAddressDetails(String firstName, String lastName, String streetAddress, String zipCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterStreetAddress(streetAddress);
        enterZipCode(zipCode);
    }

    public void waitForOrderInfoPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderInfoPageLocator));
    }
}