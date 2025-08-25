package com.digital.ui.steps ;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import com.nisum.utils.WebDriverUtils;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private OnboardingModalPage onboardingModalPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private WebDriverWait wait;

    public StepDefinitions() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
        onboardingModalPage = new OnboardingModalPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("I launch the browser")
    public void iLaunchTheBrowser() {
        // The driver initialization is already handled in the constructor.
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
       homePage.navigateToHomePage(url);
    }

    @When("User clicks on Sign In in header")
    public void userClicksOnSignInInHeader() {
        homePage.clickSignInLink();
    }

    @Then("User will wait and verifies {string} modal popup is displayed")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed(String modalType) {
        if (modalType.equals("Shopped with us before?")) {
            wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getShoppedBeforeModalTitle()));
            assert onboardingModalPage.isShoppedBeforeModalDisplayed() : "Shopped with us before? modal is not displayed";
        } else if (modalType.equals(" Welcome back!")) {
            wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getWelcomeBackModalTitle()));
            assert onboardingModalPage.isWelcomeBackModalDisplayed() : "Welcome back! modal is not displayed";
        }
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
        onboardingModalPage.clickSignInWithPassword();
    }

    @Then("User will wait until search field on homepage is interactable")
    public void userWillWaitUntilSearchFieldOnHomepageIsInteractable() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchBox()));
    }

    @When("User enter {string} in search field and press enter key")
    public void userEnterInSearchFieldAndPressEnterKey(String searchText) {
        homePage.enterSearchText(searchText);
        homePage.pressEnterOnSearchBox();
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page")
    public void userWillWaitAndVerifyThatTheUserSeesSearchedItemsOnTheProductsPage() {
        wait.until(ExpectedConditions.visibilityOf(productsPage.getProductItem()));
        assert productsPage.isProductDisplayed() : "Searched items are not displayed on the Products Page.";
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
    public void userWillWaitUntilCheckoutButtonIsClickableAndClicksCheckoutButtonUnderCartSidebar() {
        productsPage.clickCheckoutButton();
    }

    @When("User will wait until order info page is displayed")
    public void userWillWaitUntilOrderInfoPageIsDisplayed() {
       assert checkoutPage.isOrderInfoPageDisplayed() : "Order Information Page is not displayed";
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
    public void userWillWaitForAWhileAndClicksContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton(0);
    }

    @And("User clicks second Continue Button on Checkout Page")
    public void userClicksSecondContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton(1);
    }

    @When("User will wait and Selects fastest delivery time")
    public void userWillWaitAndSelectsFastestDeliveryTime() {
        checkoutPage.selectFastestDeliveryTime();
    }

    @And("User clicks third Continue Button on Checkout Page")
    public void userClicksThirdContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton(2);
    }

    @And("Execution completed")
    public void executionCompleted() {
        System.out.println("Execution completed successfully");
        driver.quit();
    }
}