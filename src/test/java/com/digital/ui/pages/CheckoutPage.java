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
    private final By firstNameField = By.xpath("//input[@name='firstName']");
    private final By lastNameField = By.xpath("//input[@id='lastName']");
    private final By streetAddressField = By.xpath("//input[@id='streetAddress']");
    private final By zipCodeField = By.xpath("//input[@id='zipCode']");
    private final By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private final By deliveryTimeSlot = By.xpath("(//div[@class='RadioGroup_radioGroupContainer__3mR8d'])[1]//label"); // Selects first available
    private final By searchfieldonHomepage = By.xpath("//*[@name='q']");

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

    public WebElement getDeliveryTimeSlot() {
        return driver.findElement(deliveryTimeSlot);
    }

    public WebElement getsearchfieldonHomepage() {
        return wait.until(ExpectedConditions.elementToBeClickable(searchfieldonHomepage));
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

    public void clickDeliveryTimeSlot() {
        getDeliveryTimeSlot().click();
    }

    public boolean issearchfieldonHomepageInteractable() {
        return getsearchfieldonHomepage().isDisplayed();
    }
}