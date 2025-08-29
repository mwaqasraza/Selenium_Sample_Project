package com.digital.ui.pages;

// SignInPage.java
package com.nisum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By passwordField = By.xpath("//input[@id='password']");
    private final By signInButton = By.xpath("//button[text()='Sign In']");
    private final By broadwayAddressLink = By.xpath("//a[contains(text(),'5100 Broadway')]"); // Example locator

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    public WebElement getBroadwayAddressLink() {
        return driver.findElement(broadwayAddressLink);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

    public void clickBroadwayAddressLink() {
        wait.until(ExpectedConditions.elementToBeClickable(getBroadwayAddressLink())).click();
    }
}