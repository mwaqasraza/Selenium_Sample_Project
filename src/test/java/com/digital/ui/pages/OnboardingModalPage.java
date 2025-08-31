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

    // Global By Locators
    private final By shoppedWithUsBeforeModal = By.xpath("//h2[contains(text(),'Shopped with us before?')]");
    private final By welcomeBackModal = By.xpath("//h1[contains(text(),'Welcome back!')]");

    public OnboardingModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
    public WebElement getShoppedWithUsBeforeModal() {
        return driver.findElement(shoppedWithUsBeforeModal);
    }

    public WebElement getWelcomeBackModal() {
        return driver.findElement(welcomeBackModal);
    }


    // Public action methods for page related actions
    public boolean isShoppedWithUsBeforeModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(shoppedWithUsBeforeModal));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWelcomeBackModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackModal));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}