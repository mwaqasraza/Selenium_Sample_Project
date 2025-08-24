package com.digital.ui.steps ;



import com.nisum.pages.CheckoutPage;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPageSteps {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutPageSteps() {
        driver = WebDriverUtils.getDriver();
        checkoutPage = new CheckoutPage(driver);
    }
}