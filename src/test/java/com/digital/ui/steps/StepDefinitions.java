package com.digital.ui.steps ;



import com.safeway.pages.CheckoutPage;
import com.safeway.pages.HomePage;
import com.safeway.pages.OnboardingModalPage;
import com.safeway.pages.ProductsPage;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.datatable.DataTable;
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
    private OnboardingModalPage onboardingModalPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private WebDriverWait wait;

    public StepDefinitions() {
        this.driver = WebDriverUtils.getDriver();
        this.homePage = new HomePage(driver);
        this.onboardingModalPage = new OnboardingModalPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        // Browser launch is handled in the WebDriverUtils.getDriver() method.
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @When("User clicks on Sign In in header")
    public void user_clicks_on_sign_in_in_header() {
        homePage.clickSignInLink();
    }

    @Then("User will wait and verifies {string} modal popup is displayed")
    public void user_will_wait_and_verifies_modal_popup_is_displayed(String modalType) {
        if (modalType.equals("Shopped with us before?")) {
            assert onboardingModalPage.isShoppedWithUsBeforeModalDisplayed() : "Shopped with us before? modal is not displayed";
        } else if (modalType.equals("Welcome back!")) {
            assert onboardingModalPage.isWelcomeBackModalDisplayed() : "Welcome back! modal is not displayed";
        } else {
            throw new IllegalArgumentException("Invalid modal type: " + modalType);
        }
    }

    @When("User clicks on Sign in from sidebar menu")
    public void user_clicks_on_sign_in_from_sidebar_menu() {
        homePage.clickSignInSidebarLink();
    }

    @Then("User Enters {string} Email ID")
    public void user_enters_email_id(String email) {
        homePage.enterEmail(email);
    }

    @When("User clicks on Sign in with password")
    public void user_clicks_on_sign_in_with_password() {
        homePage.clickSignInWithPasswordButton();
    }

    @Then("User will wait until search field on homepage is interactable")
    public void user_will_wait_until_search_field_on_homepage_is_interactable() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchBox()));
    }

    @When("User enter {string} in search field and press enter key")
    public void user_enter_in_search_field_and_press_enter_key(String searchText) {
        homePage.enterSearchText(searchText);
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("User will wait and verify that the user sees searched items on the Products Page")
    public void user_will_wait_and_verify_that_the_user_sees_searched_items_on_the_products_page() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productsPage.getProductItems()));
        assert productsPage.areProductsDisplayed() : "No products displayed after search.";
    }

    @When("User clicks on the first item Add Button from the Products Page")
    public void user_clicks_on_the_first_item_add_button_from_the_products_page() {
        productsPage.clickFirstItemAddButton();
    }

    @When("User Clicks Cart Icon in Header")
    public void user_clicks_cart_icon_in_header() {
        productsPage.clickCartIcon();
    }

    @When("User will wait until checkout button is clickable and clicks Checkout Button under cart sidebar")
    public void user_will_wait_until_checkout_button_is_clickable_and_clicks_checkout_button_under_cart_sidebar() {
        productsPage.clickCheckoutButton();
    }

    @When("User will wait until order info page is displayed")
    public void user_will_wait_until_order_info_page_is_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
    }

    @Then("User Enters valid AddressDetails details on Checkout Page using following details")
    public void user_enters_valid_address_details_details_on_checkout_page_using_following_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> addressDetails = data.get(0); // Get the first (and only) row

        checkoutPage.enterFirstName(addressDetails.get("FirstName"));
        checkoutPage.enterLastName(addressDetails.get("LastName"));
        checkoutPage.enterStreetAddress(addressDetails.get("StreetAddress"));
        checkoutPage.enterZipCode(addressDetails.get("ZIPCODE"));
    }

    @Then("User will wait for a while and clicks Continue Button on Checkout Page")
    public void user_will_wait_for_a_while_and_clicks_continue_button_on_checkout_page() {
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.clickContinueButton();
    }

    @Then("User clicks second Continue Button on Checkout Page")
    public void user_clicks_second_continue_button_on_checkout_page() {
        checkoutPage.clickContinueButton();
    }

    @When("User will wait and Selects fastest delivery time")
    public void user_will_wait_and_selects_fastest_delivery_time() {
        checkoutPage.selectFastestDeliveryTime();
    }

    @Then("User clicks third Continue Button on Checkout Page")
    public void user_clicks_third_continue_button_on_checkout_page() {
        checkoutPage.clickContinueButton();
    }

    @Then("Execution completed.")
    public void execution_completed() {
        driver.quit();
    }
}