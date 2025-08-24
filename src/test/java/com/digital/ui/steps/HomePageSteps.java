package com.digital.ui.steps ;



import com.nisum.pages.HomePage;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageSteps {

    private WebDriver driver;
    private HomePage homePage;

    public HomePageSteps() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
    }

    @Then("User will wait until search field on homepage is interactable")
    public void userWillWaitUntilSearchFieldOnHomepageIsInteractable() {
        // Assuming this means waiting for a specific element on the checkout page to load
        // You'll need to define a locator for this element in CheckoutPage.java
        // Example:
        // wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.getOrderInfoPageElement()));
        //For now I have introduced Thread.sleep, you can change according to above suggestions
        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
        //checkoutPage.issearchfieldonHomepageInteractable();
    }
}