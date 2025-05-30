package com.a8.locators;

import org.openqa.selenium.By;

public class LoginLocators {
    //pakai FndBy() untuk menghindari hardcode locator dan WebElement
    public static final By USERNAME_INPUT = By.name("username");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    public static final By ERROR_MESSAGE = By.xpath("//p[contains(text(), 'Incorrect username or password')]");
    public static final By DASHBOARD_NAVBAR = By.xpath("//h1[contains(text(),'Dasbor - Bendahara')]");
}
