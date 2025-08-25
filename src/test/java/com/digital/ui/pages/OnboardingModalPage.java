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

    private By shoppedWithUsBeforeModal = By.xpath("//h2[contains(text(),'Shopped with us before?')]");
    private By welcomeBackModal = By.xpath("//h2[contains(text(),'Welcome back!')]");

    public OnboardingModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getShoppedWithUsBeforeModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppedWithUsBeforeModal));
    }

    public WebElement getWelcomeBackModal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackModal));
    }

    public boolean isShoppedWithUsBeforeModalDisplayed() {
        try {
            return getShoppedWithUsBeforeModal().isDisplayed();
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
}