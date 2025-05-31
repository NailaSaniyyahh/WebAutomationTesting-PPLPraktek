package com.a8.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutLocators {

    @FindBy(css = "button:has(svg.lucide-log-out)")
    public WebElement LOGOUT_BUTTON;

    @FindBy(xpath = "//button[normalize-space()='Ya']")
    public WebElement CONFIRM_LOGOUT_YES_BUTTON;

    @FindBy(name = "username")
    public WebElement LOGIN_PAGE_ELEMENT;

}
