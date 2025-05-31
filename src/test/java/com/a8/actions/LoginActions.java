package com.a8.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.a8.locators.LoginLocators;

public class LoginActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginLocators locators;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.locators = new LoginLocators();
        PageFactory.initElements(driver, this.locators);
    }
    

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(locators.USERNAME_INPUT));
        locators.USERNAME_INPUT.clear();
        locators.USERNAME_INPUT.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(locators.PASSWORD_INPUT));
        locators.PASSWORD_INPUT.clear();
        locators.PASSWORD_INPUT.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.LOGIN_BUTTON));
        locators.LOGIN_BUTTON.click();
    }

    public boolean isDashboardLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(locators.DASHBOARD_NAVBAR)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNavbarDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(locators.DASHBOARD_NAVBAR)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getNotificationMessage() {
        return wait.until(ExpectedConditions.visibilityOf(locators.ERROR_MESSAGE)).getText();
    }
}
