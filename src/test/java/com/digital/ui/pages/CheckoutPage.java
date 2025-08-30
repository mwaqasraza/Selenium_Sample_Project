package com.digital.ui.pages;

// CheckoutPage.java
package com.nisum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Global By Locators
    private By firstNameField = By.xpath("//input[@name='firstName']");
    private By lastNameField = By.xpath("//input[@id='lastName']");
    private By addressLine1Field = By.xpath("//input[@id='streetAddress']");
    private By zipCodeField = By.xpath("//input[@id='zipCode']");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");

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

    public WebElement getAddressLine1Field() {
        return driver.findElement(addressLine1Field);
    }

    public WebElement getZipCodeField() {
        return driver.findElement(zipCodeField);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    // Public action methods for page related actions
    public void enterFirstName(String firstName) {
        getFirstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameField().sendKeys(lastName);
    }

    public void enterAddressLine1(String address) {
        getAddressLine1Field().sendKeys(address);
    }

    public void enterZipCode(String zipCode) {
        getZipCodeField().sendKeys(zipCode);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }
}