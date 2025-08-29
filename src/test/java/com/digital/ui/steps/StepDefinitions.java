package com.digital.ui.steps;

// StepDefinitions.java
package com.nisum.stepdefinitions;

import com.nisum.pages.*;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private OrderConfirmationPage orderConfirmationPage;
    private OnboardingModalPage onboardingModalPage;

    @Before
    public void setup() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        onboardingModalPage = new OnboardingModalPage(driver);
    }

    @After
    public void tearDown() throws SQLException {
        //MySQLUtils.disconnect_DB();
        driver.quit();
    }

    @Given("I launch the browser.")
    public void iLaunchTheBrowser() {
        // Browser launch is handled in the @Before hook
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver.get(url);
    }

    @When("User clicks on Sign In in header.")
    public void userClicksOnSignInInHeader() {
        homePage.clickSignInHeaderLink();
    }

    @Then("User will wait and verifies {string} modal popup is displayed.")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed(String modalType) {
        if (modalType.equals("Shopped with us before?")) {
            homePage.waitUntilShoppedWithUsBeforeModalIsDisplayed();
            Assert.assertTrue(onboardingModalPage.isShoppedWithUsBeforeModalPopupDisplayed());

        } else if (modalType.equals(" Welcome back!")) {
            homePage.waitUntilWelcomeBackModalIsDisplayed();
        }
    }

    @When("User clicks on Sign in from sidebar menu.")
    public void userClicksOnSignInFromSidebarMenu() {
        homePage.clickSignInSidebarLink();
    }

    @And("User Enters {string} Email ID.")
    public void userEntersEmailID(String email) {
        homePage.enterEmail(email);
    }

    @When("User clicks on Sign in with password.")
    public void userClicksOnSignInWithPassword() {
        homePage.clickSignInWithPasswordButton();
    }

    @Then("User will wait until {string} is clickable and user will Clicks on it.")
    public void userWillWaitUntilIsClickableAndUserWillClicksOnIt(String element) {
        if (element.equals("5100 Broadway")) {
            signInPage.clickBroadwayAddressLink();
        }
    }

    @When("User clicks StoreAddress on Home Page.")
    public void userClicksStoreAddressOnHomePage() {
        homePage.clickStoreAddress();
    }

    @Then("User will wait and verifies {string} modal popup is displayed.")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed2(String modalText) {
        homePage.waitUntilStoreModalIsDisplayed();
        //Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'" + modalText + "')]")).isDisplayed()); // Alternative assertion

    }

    @And("User enters ZIP Code {string} in ZipCode field.")
    public void userEntersZIPCodeInZipCodeField(String zipCode) {
        homePage.enterZipCode(zipCode);
    }

    @When("User clicks Search button.")
    public void userClicksSearchButton() {
        homePage.clickSearchIcon();
    }

    @And("User clicks DeliveryTab.")
    public void userClicksDeliveryTab() {
        homePage.clickDeliveryTab();
    }

    @And("User clicks Select button against any Shop.")
    public void userClicksSelectButtonAgainstAnyShop() {
        homePage.clickSelectShopButton();
    }

    @Then("User will wait until search field on homepage is interactable.")
    public void userWillWaitUntilSearchFieldOnHomepageIsInteractable() {
        homePage.waitUntilSearchFieldIsInteractable();
    }

    @When("User enter {string} in search field and press enter key.")
    public void userEnterInSearchFieldAndPressEnterKey(String searchText) {
        homePage.enterSearchTextAndPressEnter(searchText);
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page.")
    public void userWillWaitAndVerifyThatTheUserSeesSearchedItemsOnTheProductsPage() {
        Assert.assertTrue(productsPage.getProductItems().size() > 0);
    }

    @When("User clicks on the first item Add Button from the Products Page.")
    public void userClicksOnTheFirstItemAddButtonFromTheProductsPage() {
        productsPage.clickFirstItemAddButton();
    }

    @When("User Clicks Cart Icon in Header.")
    public void userClicksCartIconInHeader() {
        productsPage.clickCartIcon();
    }

    @When("User will wait until checkout button is clickable and clicks Checkout Button under cart sidebar.")
    public void userWillWaitUntilCheckoutButtonIsClickableAndClicksCheckoutButtonUnderCartSidebar() {
        productsPage.waitUntilCheckoutButtonIsClickable();
        productsPage.clickCheckoutButton();
    }

    @When("User will wait until order info page is displayed.")
    public void userWillWaitUntilOrderInfoPageIsDisplayed() {
        checkoutPage.waitUntilOrderInfoPageIsDisplayed();
    }

    @And("User enters valid AddressDetails details on Checkout Page using following details.")
    public void userEntersValidAddressDetailsDetailsOnCheckoutPageUsingFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> addressDetails = data.get(0); // Get the first row

        checkoutPage.enterFirstName(addressDetails.get("FirstName"));
        checkoutPage.enterLastName(addressDetails.get("LastName"));
        checkoutPage.enterAddressLine1(addressDetails.get("StreetAddress"));
        checkoutPage.enterZipCode(addressDetails.get("ZIPCODE"));
    }

    @And("User will wait for a while and clicks Continue Button on Checkout Page.")
    public void userWillWaitForAWhileAndClicksContinueButtonOnCheckoutPage() throws InterruptedException {
        Thread.sleep(2000);
        checkoutPage.clickContinueButton();
    }

    @And("User clicks second Continue Button on Checkout Page.")
    public void userClicksSecondContinueButtonOnCheckoutPage() {
        checkoutPage.clickSecondContinueButton();
    }

    @When("User will wait and Selects fastest delivery time.")
    public void userWillWaitAndSelectsFastestDeliveryTime() {
        checkoutPage.clickFastestDeliveryTime();
    }

    @And("User clicks third Continue Button on Checkout Page.")
    public void userClicksThirdContinueButtonOnCheckoutPage() {
        checkoutPage.clickThirdContinueButton();
    }

    @And("Execution completed.")
    public void executionCompleted() {
        System.out.println("Test execution completed.");
    }

}