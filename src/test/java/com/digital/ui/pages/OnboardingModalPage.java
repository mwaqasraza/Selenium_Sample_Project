package com.digital.ui.pages;

// OnboardingModalPage.java
package com.nisum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingModalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By ShoppedWithUsBeforeModalPopup = By.xpath("//h2[contains(text(),'Shopped with us before?')]");


    public OnboardingModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getShoppedWithUsBeforeModalPopup() {
        return driver.findElement(ShoppedWithUsBeforeModalPopup);
    }


    public boolean isShoppedWithUsBeforeModalPopupDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppedWithUsBeforeModalPopup));
            return getShoppedWithUsBeforeModalPopup().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}