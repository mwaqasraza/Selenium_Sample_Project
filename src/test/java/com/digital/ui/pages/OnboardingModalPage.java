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

    // Locators for the "Shopped with us before?" modal
    private final By emailIdField = By.id("emailAddress");
    private final By signInWithPasswordButton = By.xpath("//button[text()='Sign in with password']");
    private final By shoppedWithUsBeforeModal = By.xpath("//h2[text()='Shopped with us before?']");

    public OnboardingModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters
    public WebElement getEmailIdField() {
        return driver.findElement(emailIdField);
    }

    public WebElement getSignInWithPasswordButton() {
        return driver.findElement(signInWithPasswordButton);
    }

    public WebElement getShoppedWithUsBeforeModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppedWithUsBeforeModal));
    }


    // Actions

    public void enterEmailId(String email) {
        getEmailIdField().sendKeys(email);
    }

    public void clickSignInWithPasswordButton() {
        getSignInWithPasswordButton().click();
    }
}