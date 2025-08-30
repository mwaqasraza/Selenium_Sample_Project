package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingModalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By emailField = By.xpath("//input[@name='email']");
    private final By signInWithPasswordButton = By.xpath("//button[contains(text(),'Sign in with password')]");


    public OnboardingModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters
    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getSignInWithPasswordButton() {
        return driver.findElement(signInWithPasswordButton);
    }

    // Actions
    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void clickSignInWithPasswordButton() {
        getSignInWithPasswordButton().click();
    }
}