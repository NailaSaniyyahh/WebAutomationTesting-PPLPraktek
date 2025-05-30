package com.a8.locators;

import org.openqa.selenium.By;

public class LogoutLocators {
    public static final By LOGOUT_BUTTON = By.xpath("(//button[@type='button'])[last()]");
    public static final By CONFIRM_LOGOUT_YES_BUTTON = By.xpath("//button[normalize-space(text())='Ya']");
    public static final By LOGIN_PAGE_ELEMENT = By.cssSelector("form[class*='login-form']");
}
