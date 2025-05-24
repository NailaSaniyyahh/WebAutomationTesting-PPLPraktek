package com.a8.stepDefinitions;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.a8.actions.LoginActions;
import com.a8.locators.LoginLocators;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginActions loginActions;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup(); // otomatis download & set driver Edge
        driver = new EdgeDriver();
        loginActions = new LoginActions(driver);
    }

    @Given("User has opened the browser")
    public void user_opens_browser() {
        // Browser sudah dibuka di setup()
    }

    @Given("User navigates to the login page with url {string}")
    public void user_navigates_to_login_page(String url) {
        driver.get(url);
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
        // String currentUrl = driver.getCurrentUrl();
        // assertTrue(currentUrl.contains("/dashboard") || currentUrl.contains("dashboard"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean navbarVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.DASHBOARD_NAVBAR)).isDisplayed();
        assertTrue(navbarVisible, "Dashboard navbar not visible");
    }

    @Then("User should be able to see navigation bar for bendahara")
    public void user_should_see_navbar_for_bendahara() {
        assertTrue(loginActions.isNavbarDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
