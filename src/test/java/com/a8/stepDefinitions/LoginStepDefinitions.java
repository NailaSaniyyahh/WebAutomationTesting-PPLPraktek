package com.a8.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.a8.actions.LoginActions;
import com.a8.core.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginActions loginActions;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        loginActions = new LoginActions(driver);
    }

    @Given("User has opened the browser")
    public void user_opens_browser() {}    
    
    @Given("User navigates to the login page with url {string}")
    public void user_navigates_to_login_page(String url) {
        driver.get(url);
    }
    
    @Given("User has not logged in")
    public void user_has_not_logged_in() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(!currentUrl.contains("dashboard"), "User is already logged in");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginActions.enterUsername(username);
        loginActions.enterPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_login_button() {
        loginActions.clickLogin();
    }

    @Then("User is navigated to the dashboard page")
    public void user_is_navigated_to_dashboard_page() {
        assertTrue(loginActions.isDashboardLoaded());
    }

    @Then("User should be able to see navigation bar for bendahara")
    public void user_should_see_navbar_for_bendahara() {
        assertTrue(loginActions.isNavbarDisplayed());
    }

    @Then("User should be able to see unsuccessful login notification message : Incorrect username or password, please try again!")
    public void user_sees_unsuccessful_login_message() {
        String actualMessage = loginActions.getNotificationMessage();
        assertEquals("Incorrect username or password, please try again!", actualMessage);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
