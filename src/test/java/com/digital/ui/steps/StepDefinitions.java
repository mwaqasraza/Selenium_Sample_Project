package com.digital.ui.steps ;



import com.nisum.pages.*;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private OnboardingModalPage onboardingModalPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private SignInPage signInPage;
    private OrderConformationPage orderConformationPage;


    public StepDefinitions() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
        onboardingModalPage = new OnboardingModalPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        signInPage = new SignInPage(driver);
        orderConformationPage = new OrderConformationPage(driver);
    }

    @Given("I launch the browser")
    public void iLaunchTheBrowser() {
        // Driver is initialized in the constructor.
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
    public void userWillWaitAndVerifiesModalPopupIsDisplayed(String modalType) {
        if (modalType.equals("Shopped with us before?")) {
            Assert.assertTrue(onboardingModalPage.getShoppedWithUsBeforeModal().isDisplayed(), "Shopped with us before? modal is not displayed");
        } else if (modalType.equals("Welcome back!")) {
            Assert.assertTrue(homePage.getWelcomeBackModal().isDisplayed(), "Welcome back! modal is not displayed");
        } else {
            throw new IllegalArgumentException("Invalid modal type: " + modalType);
        }
    }


    @When("User clicks on Sign in from sidebar menu")
    public void userClicksOnSignInFromSidebarMenu() {
        homePage.clickSignInSidebarLink();
    }

    @And("User Enters {string} Email ID")
    public void userEntersEmailID(String email) {
        onboardingModalPage.enterEmailId(email);
    }

    @When("User clicks on Sign in with password")
    public void userClicksOnSignInWithPassword() {
        onboardingModalPage.clickSignInWithPasswordButton();
    }

    @When("User enter {string} in search field and press enter key")
    public void userEnterInSearchFieldAndPressEnterKey(String searchText) {
        homePage.submitSearchText(searchText);
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page")
    public void userWillWaitAndVerifyThatTheUserSeesSearchedItemsOnTheProductsPage() {
        Assert.assertTrue(productsPage.isProductDisplayed(), "Searched items are not displayed on the Products Page.");
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

     @When("User will wait until search field on homepage is interactable")
    public void userWillWaitUntilSearchFieldOnHomepageIsInteractable() {
        Assert.assertTrue(checkoutPage.issearchfieldonHomepageInteractable(), "Search Field is not interactable");
    }


    @When("User will wait until order info page is displayed")
    public void userWillWaitUntilOrderInfoPageIsDisplayed() {
        // Assuming this means waiting for a specific element on the checkout page to load
        // You'll need to define a locator for this element in CheckoutPage.java
        // Example:
        // wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.getOrderInfoPageElement()));
        //For now I have introduced Thread.sleep, you can change according to above suggestions
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
    }


    @And("User enters valid AddressDetails details on Checkout Page using following details")
    public void userEntersValidAddressDetailsDetailsOnCheckoutPageUsingFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> addressDetails = data.get(0); // Get the first (and only) row

        checkoutPage.enterFirstName(addressDetails.get("FirstName"));
        checkoutPage.enterLastName(addressDetails.get("LastName"));
        checkoutPage.enterStreetAddress(addressDetails.get("StreetAddress"));
        checkoutPage.enterZipCode(addressDetails.get("ZIPCODE"));
    }

    @And("User will wait for a while and clicks Continue Button on Checkout Page")
    public void userClicksContinueButtonOnCheckoutPage() {
        // Replace 0 with the appropriate index if there are multiple continue buttons
        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
        checkoutPage.clickContinueButton(0);
    }

    @And("User clicks second Continue Button on Checkout Page")
    public void userClicksSecondContinueButtonOnCheckoutPage() {
        // Replace 1 with the appropriate index if there are multiple continue buttons
        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
        checkoutPage.clickContinueButton(1);
    }

    @When("User will wait and Selects fastest delivery time")
    public void userSelectsFastestDeliveryTime() {
        // Implement the logic to select the fastest delivery time (e.g., click a radio button)
        // checkoutPage.selectFastestDeliveryTime(); // You'll need to add this method to CheckoutPage
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        checkoutPage.clickDeliveryTimeSlot();
    }

    @And("User clicks third Continue Button on Checkout Page")
    public void userClicksThirdContinueButtonOnCheckoutPage() {
        // Replace 2 with the appropriate index if there are multiple continue buttons
         try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
        checkoutPage.clickContinueButton(2);
    }

    @And("Execution completed")
    public void executionCompleted() {
        System.out.println("Execution completed");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}