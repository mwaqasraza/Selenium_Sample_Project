package com.digital.ui.pages;

// OnboardingModalPage.java
//package com.safeway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingModalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By shoppedBeforeModal = By.xpath("//h1[text()='Shopped with us before?']");
    private By welcomeBackModal = By.xpath("//h1[contains(text(),' Welcome back!')]");
    private By signInWithPasswordModal = By.xpath("//h1[contains(text(),'Sign in with password')]");
    private By findAStoreModal = By.xpath("//h4[contains(text(),' Find a Store near you, or shop for Delivery or Pickup. ')]");


    public OnboardingModalPage(WebDriver driver) {
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getShoppedBeforeModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppedBeforeModal));
    }

    public WebElement getWelcomeBackModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackModal));
    }
    public WebElement getSignInWithPasswordModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signInWithPasswordModal));
    }
        public WebElement getFindAStoreModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(findAStoreModal));
    }

    public boolean isShoppedBeforeModalDisplayed() {
        try {
            return getShoppedBeforeModal().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
      public boolean isWelcomeBackModalDisplayed() {
        try {
            return getWelcomeBackModal().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSignInWithPasswordModalDisplayed() {
        try {
            return getSignInWithPasswordModal().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isFindAStoreModalDisplayed() {
        try {
            return getFindAStoreModal().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}