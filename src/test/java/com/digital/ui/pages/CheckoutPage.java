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

    // Locators
    private By firstNameField = By.xpath("//input[@name='firstName']");
    private By lastNameField = By.xpath("//input[@id='lastName']");
    private By streetAddressField = By.xpath("//input[@id='streetAddress']");
    private By zipCodeField = By.xpath("//input[@id='zipCode']");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By deliveryTimeSlots = By.xpath("//div[@class='time-slots']//label");
    private By orderInfoPage = By.xpath("//h2[text()='Delivery Details']");

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

    public List<WebElement> getContinueButtons() {
        return driver.findElements(continueButton);
    }

    public List<WebElement> getDeliveryTimeSlots() {
        return driver.findElements(deliveryTimeSlots);
    }

    public WebElement getOrderInfoPage() {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(orderInfoPage));
    }
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

    public void clickContinueButton(int index) {
        getContinueButtons().get(index).click();
    }

    public void selectFastestDeliveryTime() {
        // Select the first available time slot
        getDeliveryTimeSlots().get(0).click();
    }

}