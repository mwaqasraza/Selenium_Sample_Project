package com.digital.ui.pages;

// CheckoutPage.java
//package com.safeway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameField = By.xpath("//input[@id='firstName']");
    private By lastNameField = By.xpath("//input[@id='lastName']");
    private By streetAddressField = By.xpath("//input[@id='streetAddress']");
    private By zipCodeField = By.xpath("//input[@id='zipCode']");
    private By continueButton = By.xpath("//*[@id=\"update-address-continue\"]");
    private By continueButton2 = By.xpath("//*[@id=\"deliveryInfoContent\"]/div/div/div[4]/div[1]/button");
    private By continueButton3 = By.xpath("//*[@id=\"reserveSlotsContinue\"]");

    private By fastestDeliveryTime = By.xpath("//*[@id=\"2\"]/app-reserveblock/div/div/div[3]/app-delivery-window-type/div/div[1]/div/div"); //Example
    private By oneHourTimeslots = By.xpath("//*[contains(text(), '1 Hour Timeslots')]"); // Example, refine
    private By continueInReserveTimeSlot = By.xpath("//button[contains(text(), 'Continue')]"); // Refine
    private By orderSummary = By.xpath("//*[contains(text(), 'Order Summary')]"); // Refine
    private By itemPreferencesSection = By.xpath("//*[contains(text(), 'Item Preferences')]"); // Example
    private By continueInItemPreferences = By.xpath("//button[contains(text(), 'Continue')]"); //Refine
    private By itemPreferencesTickMark = By.xpath("//*[@data-qa='item-preferences-tick']"); //Example
    private By promoCodeTab = By.xpath("//*[@data-qa='promo-code-tab']"); //Example, refine
    private By paymentDetailsSection = By.xpath("//*[contains(text(), 'Payment Details')]"); //Example
    private By placeOrderButton = By.xpath("//button[contains(text(), 'Place Order')]"); //Refine

    public CheckoutPage(WebDriver driver) {
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getFirstNameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
    }

    public WebElement getLastNameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
    }

    public WebElement getStreetAddressField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddressField));
    }

    public WebElement getZipCodeField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField));
    }

    public WebElement getContinueButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(continueButton));
    }
    public WebElement getContinueButton2() {
        return wait.until(ExpectedConditions.elementToBeClickable(continueButton2));
    }
    public WebElement getContinueButton3() {
        return wait.until(ExpectedConditions.elementToBeClickable(continueButton3));
    }

    public WebElement getFastestDeliveryTime() {
        return wait.until(ExpectedConditions.elementToBeClickable(fastestDeliveryTime));
    }

      public WebElement getContinueInReserveTimeSlot() {
        return wait.until(ExpectedConditions.elementToBeClickable(continueInReserveTimeSlot));
    }
       public WebElement getContinueInItemPreferences() {
        return wait.until(ExpectedConditions.elementToBeClickable(continueInItemPreferences));
    }

    public void enterFirstName(String firstName) {
        getFirstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameField().sendKeys(lastName);
    }

    public void enterStreetAddress(String streetAddress) {
        getStreetAddressField().sendKeys(streetAddress);
    }

    public void enterZipCode(String zipCode) {
        getZipCodeField().sendKeys(zipCode);
    }

    public void clickContinueButton(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getContinueButton());
        getContinueButton().click();
    }
    public void clickContinueButton2(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getContinueButton2());
        getContinueButton2().click();
    }
    public void clickContinueButton3(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getContinueButton3());
        getContinueButton3().click();
    }
       public void clickContinueButtonInReserveTimeSlot() {
        getContinueInReserveTimeSlot().click();
    }
          public void clickContinueButtonInItemPreferences() {
        getContinueInItemPreferences().click();
    }
    public void selectFastestDeliveryTime() {
        wait.until(ExpectedConditions.visibilityOf(getFastestDeliveryTime()));
        getFastestDeliveryTime().click();
    }

    public boolean isOneHourTimeslotsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fastestDeliveryTime)).isDisplayed();
    }

    public boolean isOrderSummaryDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderSummary)).isDisplayed();
    }
      public boolean isItemPreferencesSectionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemPreferencesSection)).isDisplayed();
    }
    public boolean isPromoCodeTabEnabled() {
        // Implementation to check if promo code tab is enabled
        // This might involve checking an attribute like 'disabled' or similar.
        return true; // Placeholder -  Replace with actual logic
    }

    public void enterPaymentDetails() {
        // Implementation for entering payment details.  This could involve interacting with iframes
        // or other complex elements.
    }
    public void clickPlaceOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

}