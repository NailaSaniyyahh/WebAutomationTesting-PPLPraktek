package com.a8.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.a8.actions.LogoutActions;
import com.a8.core.DriverManager;
import com.a8.actions.LoginActions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinitions {
    private WebDriver driver;
    private LogoutActions logoutActions;
    private LoginActions loginActions;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        logoutActions = new LogoutActions(driver);
        loginActions = new LoginActions(driver);
    }

    @When("User clicks on the Logout button")
    public void user_clicks_on_the_logout_button() {
        logoutActions.clickLogoutButton();
    }

    @When("User confirms logout by clicking {string} button in the confirmation modal")
    public void user_confirms_logout_by_clicking_button(String buttonText) {
        if (buttonText.equalsIgnoreCase("Ya")) {
            logoutActions.confirmLogout();
        }
    }

    @Then("User is redirected to the login page")
    public void user_is_redirected_to_the_login_page() {
        assertTrue(logoutActions.isRedirectedToLoginPage(), "User was not redirected to login page");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
