package com.digital.ui.pages;

// OrderConformationPage.java
//package com.safeway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConformationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Global By Locators
    private By title = By.xpath("//h1[text()='Order Confirmation']");

    public OrderConformationPage(WebDriver driver) {
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods
    public WebElement getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }

    // Public action methods
    public boolean isTitleDisplayed() {
        try {
            return getTitle().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}