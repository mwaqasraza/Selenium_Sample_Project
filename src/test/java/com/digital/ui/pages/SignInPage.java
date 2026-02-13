package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Global By Locators
    private final By passwordField = By.xpath("//input[@id='j_password']");
    private final By signInButton = By.xpath("//button[contains(text(),'Sign In')]");
    private final By broadwayAddress = By.xpath("//span[text()='5100 Broadway']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    public WebElement getBroadwayAddress() {
        return driver.findElement(broadwayAddress);
    }

    // Public action methods for page related actions
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void clickBroadwayAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(broadwayAddress)).click();
    }
}