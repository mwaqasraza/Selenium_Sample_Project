package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Global By Locators
    private final By firstNameField = By.xpath("//input[@name='firstName']");
    private final By lastNameField = By.xpath("//input[@id='lastName']");
    private final By streetAddressField = By.xpath("//input[@id='streetAddress']");
    private final By zipCodeField = By.xpath("//input[@id='zipCode']");
    private final By continueButton = By.xpath("//button[contains(text(), 'Continue')]");
    private final By fastestDeliveryTime = By.xpath("//div[@class='time-slot-wrapper']//label[1]");  // Assuming the first available time is the fastest.

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
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

    public List<WebElement> getContinueButtons() {
        return driver.findElements(continueButton);
    }

    public WebElement getFastestDeliveryTime() {
        return driver.findElement(fastestDeliveryTime);
    }

    // Public action methods for page related actions
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
    }

    public void enterStreetAddress(String streetAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddressField)).sendKeys(streetAddress);
    }

    public void enterZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(zipCode);
    }

    public void clickContinueButton(int index) {
         wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

    }

    public void selectFastestDeliveryTime() {
        wait.until(ExpectedConditions.elementToBeClickable(fastestDeliveryTime)).click();
    }

    public boolean isOrderInfoPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));  // Assuming first name field is always present on order info page.
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}