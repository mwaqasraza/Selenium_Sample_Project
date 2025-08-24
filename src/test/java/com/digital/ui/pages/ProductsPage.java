package com.digital.ui.pages;

// ProductsPage.java
//package com.safeway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productItem = By.xpath("//*[@data-qa='prd-itm']");
    private By addToCartButton = By.xpath("/html/body/div[2]/div/div/div[2]/div/div[3]/div/div/div/div/div[2]/div[4]/div[2]/search-grid/div[1]/div[1]/product-item-al-v2[6]/div/div[1]/div[2]/quantity-stepper-al-v2/button");
    private By cartIcon = By.xpath("//*[@id=\"abCart\"]");  //Example locator, replace
    private By checkoutButtonUnderCartSidebar = By.xpath("//button[contains(text(),'Checkout')]");


    public ProductsPage(WebDriver driver) {
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public List<WebElement> getProductItems() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productItem));
    }

    public WebElement getAddToCartButton() {
//        wait.until(ExpectedConditions.visibilityOf((WebElement) addToCartButton));
        return wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }

    public WebElement getCartIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
    }
      public WebElement getCheckoutButtonUnderCartSidebar() {
        return wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonUnderCartSidebar));
    }

    public void clickAddToCartButton(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getAddToCartButton());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getAddToCartButton().click();
    }

    public void clickCartIcon() {
        getCartIcon().click();
    }
      public void clickCheckoutButtonUnderCartSidebar() {
        getCheckoutButtonUnderCartSidebar().click();
    }


    public boolean areProductsDisplayed() {
        return !getProductItems().isEmpty();
    }
}