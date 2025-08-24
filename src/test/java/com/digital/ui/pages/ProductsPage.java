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

    // Locators
    private By productItem = By.xpath("//*[@data-qa='prd-itm']");
    private By firstItemAddButton = By.xpath("//*[@data-qa='prd-itm'][1]//span[text()='Add']");
    private By checkoutButton = By.xpath("//button[contains(text(),'Checkout')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters for WebElements
    public WebElement getProductItem() {
        return driver.findElement(productItem);
    }

    public WebElement getFirstItemAddButton() {
        return driver.findElement(firstItemAddButton);
    }

    public WebElement getCheckoutButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }

    // Action Methods
    public void clickFirstItemAddButton() {
        getFirstItemAddButton().click();
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }
}