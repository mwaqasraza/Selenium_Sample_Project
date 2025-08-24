package com.digital.ui.pages;

// SignInPage.java
//package com.safeway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Global By Locators -  Assuming these are on a separate sign-in page/modal
    // If they are on the HomePage, move these locators to HomePage class.
    //private By emailField = By.id("enterEmail"); // Updated ID
    //private By passwordField = By.id("enterPassword"); // Updated ID
    private By signInButton = By.id("SignIn"); // Updated ID

    public SignInPage(WebDriver driver) {
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods
   /* public WebElement getEmailField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
    }

    public WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
    }*/

    public WebElement getSignInButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    }

    // Public action methods
    /*public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }*/

    public void clickSignInButton() {
        getSignInButton().click();
    }
}