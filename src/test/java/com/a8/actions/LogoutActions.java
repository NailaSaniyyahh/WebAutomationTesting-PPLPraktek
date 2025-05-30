package com.a8.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.a8.locators.LogoutLocators;
import com.a8.locators.LoginLocators;

import java.time.Duration;

public class LogoutActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public LogoutActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LogoutLocators.LOGOUT_BUTTON)).click();
    }

    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(LogoutLocators.CONFIRM_LOGOUT_YES_BUTTON)).click();
    }
    
    public boolean isRedirectedToLoginPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.USERNAME_INPUT)) != null;
    }
}
