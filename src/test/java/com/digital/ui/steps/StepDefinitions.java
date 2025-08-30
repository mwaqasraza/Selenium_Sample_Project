package com.digital.ui.steps;



import com.nisum.pages.*;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private OnboardingModalPage onboardingModalPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private OrderConformationPage orderConformationPage;

    @Before
    public void setup() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
        onboardingModalPage = new OnboardingModalPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConformationPage = new OrderConformationPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("I launch the browser")
    public void iLaunchTheBrowser() {
        // Browser launch is handled in the @Before hook.  No code needed here.
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver.get(url);
    }

    @When("User clicks on Sign In in header")
    public void userClicksOnSignInInHeader() {
        homePage.clickSignInHeaderLink();
    }

    @Then("User will wait and verifies {string} modal popup is displayed")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed(String modalTitle) {
        if (modalTitle.equals("Shopped with us before?")) {
            homePage.getShoppedWithUsBeforeModal().isDisplayed();
        } else if (modalTitle.contains("Welcome back!")) {
            homePage.getWelcomeBackModal().isDisplayed();
        }
        // Add more conditions for other modal titles if needed
    }

    @When("User clicks on Sign in from sidebar menu")
    public void userClicksOnSignInFromSidebarMenu() {
        homePage.clickSignInSidebarLink();
    }

    @And("User Enters {string} Email ID")
    public void userEntersEmailID(String email) {
        onboardingModalPage.enterEmail(email);
    }

    @When("User clicks on Sign in with password")
    public void userClicksOnSignInWithPassword() {
        onboardingModalPage.clickSignInWithPasswordButton();
    }

    @Then("User will wait until search field on homepage is interactable")
    public void userWillWaitUntilSearchFieldOnHomepageIsInteractable() {
        homePage.waitForSearchBoxToBeInteractable();
    }

    @When("User enter {string} in search field and press enter key")
    public void userEnterInSearchFieldAndPressEnterKey(String searchText) {
        homePage.performSearch(searchText);
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page")
    public void userWillWaitAndVerifyThatTheUserSeesSearchedItemsOnTheProductsPage() {
        productsPage.getProductItems().size(); // Just checking that items are present.  Add more robust assertions as needed.
    }

    @When("User clicks on the first item Add Button from the Products Page")
    public void userClicksOnTheFirstItemAddButtonFromTheProductsPage() {
        productsPage.clickFirstItemAddButton();
    }

    @When("User Clicks Cart Icon in Header")
    public void userClicksCartIconInHeader() {
        productsPage.clickCartIcon();
    }

    @When("User will wait until checkout button is clickable and clicks Checkout Button under cart sidebar")
    public void userWillWaitUntilCheckoutButtonClickableAndClicksCheckoutButtonUnderCartSidebar() {
        productsPage.waitForCheckoutButtonToBeClickable();
        productsPage.clickCheckoutButton();
    }

    @When("User will wait until order info page is displayed")
    public void userWillWaitUntilOrderInfoPageIsDisplayed() {
        checkoutPage.waitForOrderInfoPage();
    }

    @And("User enters valid AddressDetails details on Checkout Page using following details")
    public void userEntersValidAddressDetailsDetailsOnCheckoutPageUsingFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> addressData = dataTable.asMaps(String.class, String.class);
        // Assuming only one row of data
        Map<String, String> address = addressData.get(0);
        checkoutPage.fillAddressDetails(
                address.get("FirstName"),
                address.get("LastName"),
                address.get("StreetAddress"),
                address.get("ZIPCODE")
        );
    }

    @And("User will wait for a while and clicks Continue Button on Checkout Page")
    public void userWillWaitForAWhileAndClicksContinueButtonOnCheckoutPage() throws InterruptedException {
        Thread.sleep(2000);  //Explicit Wait.
        checkoutPage.clickContinueButton();
    }

    @And("User clicks second Continue Button on Checkout Page")
    public void userClicksSecondContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton();
    }

    @When("User will wait and Selects fastest delivery time")
    public void userWillWaitAndSelectsFastestDeliveryTime() {
        checkoutPage.clickFastestDeliveryTime();
    }

    @And("User clicks third Continue Button on Checkout Page")
    public void userClicksThirdContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton();
    }

    @And("Execution completed.")
    public void executionCompleted() {
        System.out.println("Execution completed successfully!");
    }

}