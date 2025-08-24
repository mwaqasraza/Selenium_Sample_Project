package com.digital.ui.steps ;



import com.nisum.pages.OrderConformationPage;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderConformationPageSteps {

    private WebDriver driver;
    private OrderConformationPage orderConformationPage;

    public OrderConformationPageSteps() {
        driver = WebDriverUtils.getDriver();
        orderConformationPage = new OrderConformationPage(driver);
    }
}