package com.digital.ui.steps;



import com.nisum.utils.WebDriverUtils;
import com.safeway.pageobjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import java.time.Duration;
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
    private WebDriverWait wait;

    public StepDefinitions() {
        driver = WebDriverUtils.getDriver();
        homePage = new HomePage(driver);
        onboardingModalPage = new OnboardingModalPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        signInPage = new SignInPage(driver);
        orderConformationPage = new OrderConformationPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("I launch the browser.")
    public void i_launch_the_browser() {
        //  WebDriverUtils.getDriver() is already called in the constructor.
        assertNotNull(driver);
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @When("User clicks on Sign In in header.")
    public void user_clicks_on_sign_in_in_header() {
        homePage.clickSignInHeaderLink();
    }

    @Then("User will wait and verifies {string} modal popup is displayed.")
    public void user_will_wait_and_verifies_modal_popup_is_displayed(String modalType) {
        if (modalType.equals("Shopped with us before?")) {
            assertTrue(onboardingModalPage.isShoppedWithUsBeforeModalDisplayed());
        } else if (modalType.equals(" Welcome back!")) {
            assertTrue(onboardingModalPage.isWelcomeBackModalDisplayed());
        }
    }

    @When("User clicks on Sign in from sidebar menu.")
    public void user_clicks_on_sign_in_from_sidebar_menu() {
        homePage.clickSignInSidebarLink();
    }

    @And("User Enters {string} Email ID.")
    public void user_enters_email_id(String email) {
        homePage.enterEmailId(email);
    }

    @When("User clicks on Sign in with password.")
    public void user_clicks_on_sign_in_with_password() {
        homePage.clickSignInWithPasswordButton();
    }

    @When("User clicks StoreAddress on Home Page.")
    public void user_clicks_store_address_on_home_page() {
        homePage.clickStoreAddress();
    }

    @And("User enters ZIP Code {string} in ZipCode field.")
    public void user_enters_zip_code_in_zip_code_field(String zipCode) {
        homePage.enterZipCode(zipCode);
    }

    @When("User clicks Search button.")
    public void user_clicks_search_button() {
        homePage.clickSearchIcon();
    }

    @And("User clicks DeliveryTab.")
    public void user_clicks_delivery_tab() {
        homePage.clickDeliveryTab();
    }

    @And("User clicks Select button against any Shop.")
    public void user_clicks_select_button_against_any_shop() {
        homePage.clickSelectShopButton();
    }

    @Then("User will wait until search field on homepage is interactable.")
    public void user_will_wait_until_search_field_on_homepage_is_interactable() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchBox()));
    }

    @When("User enter {string} in search field and press enter key.")
    public void user_enter_in_search_field_and_press_enter_key(String searchText) {
        homePage.enterSearchText(searchText);
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page.")
    public void user_will_wait_and_verify_that_the_user_sees_searched_items_on_the_products_page() {
        assertTrue(productsPage.areProductsDisplayed());
    }

    @When("User clicks on the first item Add Button from the Products Page.")
    public void user_clicks_on_the_first_item_add_button_from_the_products_page() {
        productsPage.clickFirstItemAddButton();
    }

    @When("User Clicks Cart Icon in Header.")
    public void user_clicks_cart_icon_in_header() {
        productsPage.clickCartIcon();
    }

    @When("User will wait until checkout button is clickable and clicks Checkout Button under cart sidebar.")
    public void user_will_wait_until_checkout_button_is_clickable_and_clicks_checkout_button_under_cart_sidebar() {
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.getCheckoutButton()));
        productsPage.clickCheckoutButton();
    }

    @When("User will wait until order info page is displayed.")
    public void user_will_wait_until_order_info_page_is_displayed() {
        assertTrue(checkoutPage.isOrderInfoPageDisplayed());
    }

    @And("User  User enters valid AddressDetails details on Checkout Page using following details.")
    public void user_enters_valid_address_details_details_on_checkout_page_using_following_details(DataTable dataTable) {
        List<Map<String, String>> addressDetails = dataTable.asMaps(String.class, String.class);
        Map<String, String> address = addressDetails.get(0); // Get the first row of the DataTable

        checkoutPage.enterFirstName(address.get("FirstName"));
        checkoutPage.enterLastName(address.get("LastName"));
        checkoutPage.enterStreetAddress(address.get("StreetAddress"));
        checkoutPage.enterZipCode(address.get("ZIPCODE"));
    }

    @And("User will wait for a while and clicks Continue Button on Checkout Page.")
    public void user_will_wait_for_a_while_and_clicks_continue_button_on_checkout_page() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getContinueButtons().get(0)));
        checkoutPage.clickContinueButton(0);
    }
    @And("User clicks second Continue Button on Checkout Page.")
    public void user_clicks_second_continue_button_on_checkout_page() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getContinueButtons().get(1)));
        checkoutPage.clickContinueButton(1);
    }

    @When("User will wait and Selects fastest delivery time.")
    public void user_will_wait_and_selects_fastest_delivery_time() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getFastestDeliveryTime()));
        checkoutPage.selectFastestDeliveryTime();
    }
    @And("User clicks third Continue Button on Checkout Page.")
    public void user_clicks_third_continue_button_on_checkout_page() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getContinueButtons().get(2)));
        checkoutPage.clickContinueButton(2);
    }

    @And("Execution completed.")
    public void execution_completed() {
        driver.quit();
    }
}