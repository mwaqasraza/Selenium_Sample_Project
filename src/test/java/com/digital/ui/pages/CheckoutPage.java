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

    private By firstNameField = By.xpath("//input[@name='firstName']");
    private By lastNameField = By.xpath("//input[@id='lastName']");
    private By streetAddressField = By.xpath("//input[@id='streetAddress']");
    private By zipCodeField = By.xpath("//input[@id='zipCode']");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    //private By fastestDeliveryTimeOption = By.xpath("//label[contains(text(),'Fastest')]"); //Example - needs to be adapted based on the actual UI
    private By fastestDeliveryTimeOption = By.xpath("(//label[@class='delivery-time-slot'])[1]"); // Selects the first available time slot.

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    //Getter Methods

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
        return wait.until(ExpectedConditions.elementToBeClickable(continueButton));
    }

    public WebElement getFastestDeliveryTimeOption() {
        return wait.until(ExpectedConditions.elementToBeClickable(fastestDeliveryTimeOption));
    }


    //Action Methods

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

    public void selectFastestDeliveryTime() {
        getFastestDeliveryTimeOption().click();
    }
}