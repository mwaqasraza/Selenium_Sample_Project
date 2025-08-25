package com.digital.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingModalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for the Onboarding Modal
    @FindBy(xpath = "//h2[text()='Shopped with us before?']")
    private WebElement shoppedBeforeModalTitle;

    //Locators for Welcome Back modal popup
    @FindBy(xpath = "//h2[text()=' Welcome back!']")
    private WebElement welcomeBackModalTitle;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(), 'Sign in with password')]")
    private WebElement signInWithPasswordButton;


    public OnboardingModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getShoppedBeforeModalTitle() {
        return shoppedBeforeModalTitle;
    }

    public WebElement getWelcomeBackModalTitle() {
        return welcomeBackModalTitle;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getSignInWithPasswordButton() {
        return signInWithPasswordButton;
    }

    public boolean isShoppedBeforeModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(shoppedBeforeModalTitle));
            return shoppedBeforeModalTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWelcomeBackModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(welcomeBackModalTitle));
            return welcomeBackModalTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickSignInWithPassword() {
        signInWithPasswordButton.click();
    }
}