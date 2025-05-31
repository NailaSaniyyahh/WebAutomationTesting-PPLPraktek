package com.a8.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {

    @FindBy(name = "username")
    public WebElement USERNAME_INPUT;

    @FindBy(name = "password")
    public WebElement PASSWORD_INPUT;

    @FindBy(css = "button[type='submit']")
    public WebElement LOGIN_BUTTON;

    @FindBy(xpath = "//p[contains(text(), 'Incorrect username or password')]")
    public WebElement ERROR_MESSAGE;

    @FindBy(xpath = "//h1[contains(text(),'Dasbor - Bendahara')]")
    public WebElement DASHBOARD_NAVBAR;
}
