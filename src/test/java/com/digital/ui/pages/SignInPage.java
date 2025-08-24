package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private WebDriver driver;

    // Locators
    private final By emailField = By.id("emailAddress");
    private final By passwordField = By.id("password");
    private final By signInButton = By.xpath("//button[text()='Sign In']"); // Example locator
    private final By broadwayAddressLink = By.xpath("//a[contains(text(), '5100 Broadway')]");


    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Getters
    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    public WebElement getBroadwayAddressLink() {
        return driver.findElement(broadwayAddressLink);
    }

    // Actions
    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

    public void clickBroadwayAddressLink() {
        getBroadwayAddressLink().click();
    }
}