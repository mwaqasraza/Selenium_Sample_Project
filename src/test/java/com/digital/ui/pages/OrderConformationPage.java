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

    // Global By Locators
    private final By title = By.xpath("//h1[text()='Order Confirmation']");

    public OrderConformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
    public WebElement getTitle() {
        return driver.findElement(title);
    }

    // Public action methods for page related actions
    public boolean isTitleDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(title));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}