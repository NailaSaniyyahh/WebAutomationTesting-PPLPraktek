package com.a8.actions;

import java.time.Duration;

// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.a8.locators.LoginLocators;

public class LoginActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username) {
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.USERNAME_INPUT));
        inputUsername.clear();
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.PASSWORD_INPUT));
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.LOGIN_BUTTON));
        btnLogin.click();
    }

    public boolean isNavbarDisplayed() {
        try {
            WebElement navbar = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.DASHBOARD_NAVBAR));
            return navbar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getNotificationMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.ERROR_MESSAGE));
        return notification.getText();
    }
}
