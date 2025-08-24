package com.digital.ui.steps;

// StepDefinitions.java
//package com.safeway.stepdefinitions;

import com.digital.ui.pages.*;
import com.digital.utils.WebDriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.mobile.NetworkConnection;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private OrderConformationPage orderConformationPage;
    private OnboardingModalPage onboardingModalPage;


    public StepDefinitions() {
        this.driver = WebDriverUtils.getDriver();
        this.homePage = new HomePage(driver);
        this.signInPage = new SignInPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.orderConformationPage = new OrderConformationPage(driver);
        this.onboardingModalPage = new OnboardingModalPage(driver);
    }

    @Given("I launch the browser")
    public void ilaunchthebrowser(){
//        driver = new ChromeDriver();
        // Browser launch is handled in WebDriverUtils.getDriver()
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (modalType.equalsIgnoreCase("Shopped with us before?")) {
            wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getShoppedBeforeModal()));
            Assert.assertTrue(onboardingModalPage.isShoppedBeforeModalDisplayed());
        } else if (modalType.equalsIgnoreCase(" Welcome back!")) {
              wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getWelcomeBackModal()));
            Assert.assertTrue(onboardingModalPage.isWelcomeBackModalDisplayed());

        }  else if (modalType.equalsIgnoreCase("Sign in with password")) {
             wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getSignInWithPasswordModal()));
            Assert.assertTrue(onboardingModalPage.isSignInWithPasswordModalDisplayed());
        }
          else if (modalType.equalsIgnoreCase(" Find a Store near you, or shop for Delivery or Pickup. ")) {
             wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getFindAStoreModal()));
            Assert.assertTrue(onboardingModalPage.isFindAStoreModalDisplayed());
        }
          else {
            throw new IllegalArgumentException("Unsupported modal type: " + modalType);
        }

    }

    @When("User clicks on Sign in from sidebar menu")
    public void userClicksOnSignInFromSidebarMenu() {
        homePage.clickSignInSidebarLink();
    }

    /*@Then("User will wait and verifies {string} modal popup is displayed.")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed1(String modalType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (modalType.equalsIgnoreCase(" Welcome back!")) {
              wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getWelcomeBackModal()));
            Assert.assertTrue(onboardingModalPage.isWelcomeBackModalDisplayed());

        }  else if (modalType.equalsIgnoreCase("Sign in with password")) {
             wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getSignInWithPasswordModal()));
            Assert.assertTrue(onboardingModalPage.isSignInWithPasswordModalDisplayed());
        }
          else if (modalType.equalsIgnoreCase(" Find a Store near you, or shop for Delivery or Pickup. ")) {
             wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getFindAStoreModal()));
            Assert.assertTrue(onboardingModalPage.isFindAStoreModalDisplayed());
        }
          else {
            throw new IllegalArgumentException("Unsupported modal type: " + modalType);
        }

    }
*/
    @Then("User Enters {string} Email ID")
    public void userEntersEmailID(String email) {
        homePage.enterEmailId(email);
    }

    @When("User clicks on Sign in with password")
    public void userClicksOnSignInWithPassword() {
      homePage.clickSignInButton();
    }

    /*@Then("User will wait and verifies {string} modal popup is displayed")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed2(String modalType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
          if (modalType.equalsIgnoreCase("Sign in with password")) {
             wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getSignInWithPasswordModal()));
            Assert.assertTrue(onboardingModalPage.isSignInWithPasswordModalDisplayed());
        }
          else {
            throw new IllegalArgumentException("Unsupported modal type: " + modalType);
        }
    }*/

    @Then("User Enters {string} Password")
    public void userEntersPassword(String password) {
        homePage.enterPassword(password);
    }

    @When("User clicks on Sign In")
    public void userClicksOnSignIn() {
        homePage.clickSignInButton();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("User will wait until 5100 Broadway is clickable and user will Clicks on it")
    public void userWillWaitUntilBroadwayAddressIsClickableAndUserWillClicksOnIt() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         wait.until(ExpectedConditions.elementToBeClickable(homePage.getBroadwayAddressLink())).click();
    }

    /*@Then("User will wait and verifies {string} modal popup is displayed")
    public void userWillWaitAndVerifiesModalPopupIsDisplayed3(String modalType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         if (modalType.equalsIgnoreCase(" Find a Store near you, or shop for Delivery or Pickup. ")) {
             wait.until(ExpectedConditions.visibilityOf(onboardingModalPage.getFindAStoreModal()));
            Assert.assertTrue(onboardingModalPage.isFindAStoreModalDisplayed());
        }
        else {
            throw new IllegalArgumentException("Unsupported modal type: " + modalType);
        }
    }*/

    @Then("User enters ZIP Code {string} in ZipCode field")
    public void userEntersZIPCodeInZipCodeField(String zipCode) {
        homePage.enterZipCode(zipCode);
    }

    @When("User clicks Search button")
    public void userClicksSearchButton() {
        homePage.clickSearchIcon();
    }

    @Then("User clicks DeliveryTab")
    public void userClicksDeliveryTab() {
        homePage.clickDeliveryTab();
    }

    @Then("User clicks Select button against any Shop")
    public void userClicksSelectButtonAgainstAnyShop() {
        homePage.clickSelectShopButton();
    }

    @Then("User will wait until search field on homepage is interactable")
    public void userWillWaitUntilSearchFieldOnHomepageIsInteractable() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchBox()));
    }

    @When("User enter {string} in search field and press enter key")
    public void userEnterInSearchFieldAndPressEnterKey(String searchText) {
        homePage.getSearchBox().sendKeys(searchText);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div/div/div[3]/div/div/div[2]/global-header/div/div[2]/div[1]/secondary-bar/div[6]/div/form/div/div/button")).click();
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page")
    public void userWillWaitAndVerifyThatTheUserSeesSearchedItemsOnTheProductsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(productsPage.getProductItems()));
        Assert.assertTrue(productsPage.areProductsDisplayed());
    }

    @When("User clicks on the first item Add Button from the Products Page")
    public void userClicksOnTheFirstItemAddButtonFromTheProductsPage() {
        productsPage.clickAddToCartButton(driver);
    }

    @When("User Clicks Cart Icon in Header")
    public void userClicksCartIconInHeader() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productsPage.clickCartIcon();
    }

    @When("User will wait until checkout button is clickable and clicks Checkout Button under cart sidebar")
    public void userWillWaitUntilCheckoutButtonIsClickableAndClicksCheckoutButtonUnderCartSidebar() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.getCheckoutButtonUnderCartSidebar()));
        productsPage.clickCheckoutButtonUnderCartSidebar();
    }

    @When("User will wait until order info page is displayed")
    public void userWillWaitUntilOrderInfoPageIsDisplayed() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         wait.until(ExpectedConditions.visibilityOf(checkoutPage.getFirstNameField())); //Example, refine this condition
    }

    @Then("User enters valid AddressDetails details on Checkout Page using following details")
    public void userEntersValidAddressDetailsDetailsOnCheckoutPageUsingFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> addressData = data.get(0);  //Assuming single data row

        checkoutPage.enterFirstName(addressData.get("FirstName"));
        checkoutPage.enterLastName(addressData.get("LastName"));
        checkoutPage.enterStreetAddress(addressData.get("StreetAddress"));
//        checkoutPage.enterZipCode(addressData.get("ZIPCODE"));
    }

    @Then("User clicks Continue Button on Checkout Page")
    public void userClicksContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton(driver);
    }
    @Then("User clicks second Continue Button on Checkout Page")
    public void userClicksSecondContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton2(driver);
    }
    @Then("User clicks third Continue Button on Checkout Page")
    public void userClicksThirdContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton3(driver);
    }
    @Then("Execution completed")
    public void executionCompleted(){
        driver.quit();
    }

    @Then("User will wait for a while and clicks Continue Button on Checkout Page")
    public void userWillWaitForAWhileAndClicksContinueButtonOnCheckoutPage() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getContinueButton()));
        checkoutPage.clickContinueButton(driver);
    }

    @When("User will wait and Selects fastest delivery time")
    public void userWillWaitAndSelectsFastestDeliveryTime() {
        checkoutPage.selectFastestDeliveryTime();
    }

    @Then("User Verifies {string} Hour Timeslots with view more option is Displayed")
    public void userVerifiesHourTimeslotsWithViewMoreOptionIsDisplayed(String timeSlot) {
        Assert.assertTrue(checkoutPage.isOneHourTimeslotsDisplayed());
    }

    @Then("User Clicks Continue Button In Reserve Time Slot Section")
    public void userClicksContinueButtonInReserveTimeSlotSection() {
        checkoutPage.clickContinueButtonInReserveTimeSlot();
    }

    @Then("User Verifies Order Summary is Displayed")
    public void userVerifiesOrderSummaryIsDisplayed() {
        Assert.assertTrue(checkoutPage.isOrderSummaryDisplayed());
    }

    @Then("User Validates Item Preferences Section")
    public void userValidatesItemPreferencesSection() {
        Assert.assertTrue(checkoutPage.isItemPreferencesSectionDisplayed());
    }

    @Then("User Clicks Continue Button In Item Preferences Section")
    public void userClicksContinueButtonInItemPreferencesSection() {
        checkoutPage.clickContinueButtonInItemPreferences();
    }

    @Then("User Verifies Green Tick Mark in the {string} section")
    public void userVerifiesGreenTickMarkInTheSection(String section) {
        // Implement logic to verify Green Tick Mark, Example Assertion Given.
        //Assert.assertTrue(checkoutPage.isItemPreferencesTickMarkPresent());
    }

    @Then("User Verifies PromoCode tab is Enabled")
    public void userVerifiesPromoCodeTabIsEnabled() {
        Assert.assertTrue(checkoutPage.isPromoCodeTabEnabled());
    }

    @When("User Enters Payment Details")
    public void userEntersPaymentDetails() {
        checkoutPage.enterPaymentDetails();
    }

    @Then("User Clicks Place Order Button")
    public void userClicksPlaceOrderButton() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Then("Verify that the user is navigated to the OrderConfirmation Page")
    public void verifyThatTheUserIsNavigatedToTheOrderConfirmationPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(orderConformationPage.getTitle())); //Example
        Assert.assertTrue(orderConformationPage.isTitleDisplayed());
    }

}