package com.digital.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@data-qa='prd-itm']")
    private WebElement productItem;

    @FindBy(xpath = "//*[@data-qa='prd-itm'][1]//span[text()='Add']")
    private WebElement firstItemAddButton;

    @FindBy(xpath = "//*[@id='cart-icon']")
    private WebElement cartIcon;

    @FindBy(xpath = "//button[contains(text(), 'Checkout')]")
    private WebElement checkoutButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getProductItem() {
        return productItem;
    }

    public WebElement getFirstItemAddButton() {
        return firstItemAddButton;
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public boolean isProductDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productItem));
            return productItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickFirstItemAddButton() {
        firstItemAddButton.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}