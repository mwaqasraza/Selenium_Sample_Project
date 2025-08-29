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

    private final By firstNameField = By.xpath("//input[@name='firstName']");
    private final By lastNameField = By.xpath("//input[@id='lastName']");
    private final By addressLine1Field = By.xpath("//input[@id='streetAddress']");
    private final By zipCodeField = By.xpath("//input[@id='zipCode']");
    private final By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private final By fastestDeliveryTime = By.xpath("(//label[@class='delivery-time-slot'])[1]");
    private final By secondContinueButton = By.xpath("(//button[contains(text(),'Continue')])[2]");
    private final By thirdContinueButton = By.xpath("(//button[contains(text(),'Continue')])[3]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

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

    public WebElement getFastestDeliveryTime() {
        return driver.findElement(fastestDeliveryTime);
    }

    public WebElement getSecondContinueButton() {
        return driver.findElement(secondContinueButton);
    }

    public WebElement getThirdContinueButton() {
        return driver.findElement(thirdContinueButton);
    }

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

    public void clickFastestDeliveryTime() {
        getFastestDeliveryTime().click();
    }

    public void clickSecondContinueButton() {
        getSecondContinueButton().click();
    }

    public void clickThirdContinueButton() {
        getThirdContinueButton().click();
    }

    public void waitUntilOrderInfoPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Order Information')]")));
    }
}