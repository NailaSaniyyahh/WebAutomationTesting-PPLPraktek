package com.a8.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.a8.locators.LogoutLocators;
import com.a8.locators.LoginLocators;

import java.time.Duration;

public class LogoutActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private LogoutLocators locators;

    public LogoutActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.locators = new LogoutLocators();
        PageFactory.initElements(driver, this.locators);
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOf(locators.LOGOUT_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(locators.LOGOUT_BUTTON)).click();
    }


    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.CONFIRM_LOGOUT_YES_BUTTON)).click();
    }
    
    public boolean isRedirectedToLoginPage() {
        return wait.until(ExpectedConditions.visibilityOf(locators.LOGIN_PAGE_ELEMENT)).isDisplayed();
    }
}
