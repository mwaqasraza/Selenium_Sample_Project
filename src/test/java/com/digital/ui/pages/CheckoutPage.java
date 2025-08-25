package com.digital.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='streetAddress']")
    private WebElement streetAddressField;

    @FindBy(xpath = "//input[@id='zipCode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    private List<WebElement> continueButtons;

    @FindBy(xpath = "//span[contains(text(), 'Fastest')]")
    private WebElement fastestDeliveryTime;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getStreetAddressField() {
        return streetAddressField;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public List<WebElement> getContinueButtons() {
        return continueButtons;
    }

    public WebElement getFastestDeliveryTime() {
        return fastestDeliveryTime;
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterStreetAddress(String streetAddress) {
        streetAddressField.sendKeys(streetAddress);
    }

    public void enterZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);
    }

    public void clickContinueButton(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(continueButtons.get(index))).click();
    }

    public void selectFastestDeliveryTime() {
        wait.until(ExpectedConditions.elementToBeClickable(fastestDeliveryTime)).click();
    }

    public boolean isOrderInfoPageDisplayed() {
      try {
            return firstNameField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}