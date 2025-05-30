Feature: Login Functionality

  Background:
    Given User has opened the browser
    And User navigates to the login page with url "http://ptbsp.ddns.net:6882"
    And User has not logged in

  @Positive @TC01
  Scenario: Check login is successful with valid credentials as role "bendahara"
    When User enters username "bendahara" and password "admin123"
    And User clicks on login button
    Then User is navigated to the dashboard page
    And User should be able to see navigation bar for bendahara

  Rule: Login is invalid when credentials are incorrect

  @Negative @TC02
  Scenario: Check login is unsuccessful with invalid username (username not valid)
    When User enters username "indra" and password "admin123"
    And User clicks on login button
    Then User should be able to see unsuccessful login notification message : Incorrect username or password, please try again!

  @Negative @TC03
  Scenario: Check login is unsuccessful with invalid credentials (password not valid)
    When User enters username "bendahara" and password "12w3q5"
    And User clicks on login button
    Then User should be able to see unsuccessful login notification message : Incorrect username or password, please try again!