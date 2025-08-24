package com.digital.ui.steps ;



import com.safeway.pageobjects.CheckoutPage;
import com.safeway.pageobjects.HomePage;
import com.safeway.pageobjects.ProductsPage;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private WebDriverWait wait;

    public StepDefinitions() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("I launch the browser") {
        // Browser launch is handled in WebDriverUtils
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver.get(url);
    }

    @When("User clicks on Sign In in header")
    public void userClicksOnSignInInHeader() {
        homePage.clickSignInLink();
    }

    @Then("User will wait and verifies {string} modal popup is displayed")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed(String modalTitle) {
        if (modalTitle.equals("Shopped with us before?")) {
            homePage.getShopperModalTitle().isDisplayed();
        } else if (modalTitle.equals(" Welcome back!")) {
            homePage.getWelcomeBackModalTitle().isDisplayed();
        }
    }

    @When("User clicks on Sign in from sidebar menu")
    public void userClicksOnSignInFromSidebarMenu() {
        homePage.clickSignInSidebarLink();
    }

    @And("User Enters {string} Email ID")
    public void userEntersEmailID(String email) {
        homePage.enterEmail(email);
    }

    @When("User clicks on Sign in with password")
    public void userClicksOnSignInWithPassword() {
        homePage.clickSignInWithPasswordButton();
    }

    @Then("User will wait until search field on homepage is interactable")
    public void userWillWaitUntilSearchFieldOnHomepageIsInteractable() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchBox()));
    }

    @When("User enter {string} in search field and press enter key")
    public void userEnterInSearchFieldAndPressEnterKey(String searchText) {
        homePage.enterSearchText(searchText);
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page")
    public void userWillWaitAndVerifyThatTheUserSeesSearchedItemsOnTheProductsPage() {
        productsPage.getProductItem().isDisplayed();
    }

    @When("User clicks on the first item Add Button from the Products Page")
    public void userClicksOnTheFirstItemAddButtonFromTheProductsPage() {
        productsPage.clickFirstItemAddButton();
    }

    @When("User Clicks Cart Icon in Header")
    public void userClicksCartIconInHeader() {
        homePage.clickCartIcon();
    }

    @When("User will wait until checkout button is clickable and clicks Checkout Button under cart sidebar")
    public void userWillWaitUntilCheckoutButtonIsClickableAndClicksCheckoutButtonUnderCartSidebar() {
        productsPage.clickCheckoutButton();
    }
    @When("User will wait until order info page is displayed")
    public void userWillWaitUntilOrderInfoPageIsDisplayed() {
        checkoutPage.getOrderInfoPage().isDisplayed();
    }
    @And("User enters valid AddressDetails details on Checkout Page using following details")
    public void userEntersValidAddressDetailsDetailsOnCheckoutPageUsingFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> addressDetails = data.get(0);

        checkoutPage.enterFirstName(addressDetails.get("FirstName"));
        checkoutPage.enterLastName(addressDetails.get("LastName"));
        checkoutPage.enterStreetAddress(addressDetails.get("StreetAddress"));
        checkoutPage.enterZipCode(addressDetails.get("ZIPCODE"));
    }

    @And("User will wait for a while and clicks Continue Button on Checkout Page")
    public void userClicksContinueButtonOnCheckoutPage() {
        // Assuming the first continue button is the one needed
        checkoutPage.clickContinueButton(0);
    }

    @And("User clicks second Continue Button on Checkout Page")
    public void userClicksSecondContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton(1);
    }

    @When("User will wait and Selects fastest delivery time")
    public void userSelectsFastestDeliveryTime() {
        checkoutPage.selectFastestDeliveryTime();
    }

    @And("User clicks third Continue Button on Checkout Page")
    public void userClicksThirdContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton(2);
    }

    @And("Execution completed")
    public void executionCompleted() {
        driver.quit();
    }

}