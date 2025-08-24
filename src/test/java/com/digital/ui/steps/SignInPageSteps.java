package com.digital.ui.steps ;



import com.nisum.pages.SignInPage;
import com.nisum.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPageSteps {

    private WebDriver driver;
    private SignInPage signInPage;

    public SignInPageSteps() {
        driver = WebDriverUtils.getDriver();
        signInPage = new SignInPage(driver);
    }
}