package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By productItems = By.xpath("//*[@data-qa='prd-itm']");
    private final By firstItemAddButton = By.xpath("//*[@data-qa='prd-itm'][1]//span[text()='Add']");
    private final By cartIcon = By.xpath("//a[@aria-label='Open mini cart']");  // Changed based on common cart implementation
    private final By checkoutButton = By.xpath("//button[contains(text(), 'Checkout')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters
    public List<WebElement> getProductItems() {
        return driver.findElements(productItems);
    }

    public WebElement getFirstItemAddButton() {
        return driver.findElement(firstItemAddButton);
    }

    public WebElement getCartIcon() {
        return driver.findElement(cartIcon);
    }

    public WebElement getCheckoutButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }

    // Actions
    public void clickFirstItemAddButton() {
        getFirstItemAddButton().click();
    }

    public void clickCartIcon() {
        getCartIcon().click();
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }

    public void waitForCheckoutButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }
}