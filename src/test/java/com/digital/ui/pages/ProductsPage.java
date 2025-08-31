package com.digital.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Global By Locators
    private final By productItem = By.xpath("//*[@data-qa='prd-itm']");
    private final By firstItemAddButton = By.xpath("//*[@data-qa='prd-itm'][1]//span[text()='Add']");
    private final By cartIcon = By.xpath("//a[@aria-label='cart']");
    private final By checkoutButton = By.xpath("//button[contains(text(), 'Checkout')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Public getter methods for each element
    public WebElement getProductItem() {
        return driver.findElement(productItem);
    }

    public WebElement getFirstItemAddButton() {
        return driver.findElement(firstItemAddButton);
    }

    public WebElement getCartIcon() {
        return driver.findElement(cartIcon);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButton);
    }

    // Public action methods for page related actions
    public boolean areProductsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productItem));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickFirstItemAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(firstItemAddButton)).click();
    }

    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}