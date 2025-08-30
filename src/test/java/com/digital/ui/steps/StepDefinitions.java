package com.digital.ui.steps;

// StepDefinitions.java
package com.nisum.stepdefinitions;

import com.nisum.pages.CheckoutPage;
import com.nisum.pages.HomePage;
import com.nisum.pages.ProductsPage;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private WebDriverWait wait;

    @Before
    public void setup() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I launch the browser")
    public void iLaunchTheBrowser() {
        // Browser launch is handled in the @Before hook
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
    public void userWillWaitAndVerifiesModalPopupIsDisplayed(String modalText) {
        if (modalText.equals("Shopped with us before?")) {
            wait.until(ExpectedConditions.visibilityOf(homePage.getShoppedBeforeModal()));
        } else if (modalText.equals("Welcome back!")) {
            wait.until(ExpectedConditions.visibilityOf(homePage.getWelcomeBackModal()));
        } else {
            throw new IllegalArgumentException("Unexpected modal text: " + modalText);
        }
    }

    @When("User clicks on Sign in from sidebar menu")
    public void userClicksOnSignInFromSidebarMenu() {
        homePage.clickSignInSidebarLink();
    }

    @And("User Enters {string} Email ID")
    public void userEntersEmailID(String email) {
        homePage.enterEmailId(email);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa='prd-itm']"))); //Using direct xpath because getProductItems() returns a list and that causes the element to not be visible
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Order Information')]"))); // Changed xpath to look for a heading on the order information page
    }

    @And("User enters valid AddressDetails details on Checkout Page using following details")
    public void userEntersValidAddressDetailsDetailsOnCheckoutPageUsingFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> addressDetails = data.get(0);

        checkoutPage.enterFirstName(addressDetails.get("FirstName"));
        checkoutPage.enterLastName(addressDetails.get("LastName"));
        checkoutPage.enterAddressLine1(addressDetails.get("StreetAddress"));
        checkoutPage.enterZipCode(addressDetails.get("ZIPCODE"));
    }

    @And("User will wait for a while and clicks Continue Button on Checkout Page")
    public void userWillWaitForAWhileAndClicksContinueButtonOnCheckoutPage() throws InterruptedException {
        Thread.sleep(2000); // Wait for 2 seconds
        checkoutPage.clickContinueButton();
    }

    @And("User clicks second Continue Button on Checkout Page")
    public void userClicksSecondContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton();
    }

    @When("User will wait and Selects fastest delivery time")
    public void userWillWaitAndSelectsFastestDeliveryTime() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='radio'])[1]"))).click();
    }

    @And("User clicks third Continue Button on Checkout Page")
    public void userClicksThirdContinueButtonOnCheckoutPage() {
        checkoutPage.clickContinueButton();
    }

    @And("Execution completed.")
    public void executionCompleted() {
        System.out.println("Execution completed successfully.");
    }
}