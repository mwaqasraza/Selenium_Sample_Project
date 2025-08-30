package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConformationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By title = By.xpath("//h1[text()='Order Confirmation']");

    public OrderConformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters
    public WebElement getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)); //Explicit wait
    }

    // Actions
    public boolean isTitleDisplayed() {
        return getTitle().isDisplayed();
    }
}