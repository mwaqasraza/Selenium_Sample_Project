package com.digital.ui.pages;

// OrderConfirmationPage.java
package com.nisum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By title = By.xpath("//h1[text()='Order Confirmation']");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public void waitUntilTitleIsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }
}