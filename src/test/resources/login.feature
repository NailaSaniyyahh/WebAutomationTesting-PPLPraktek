Feature: Login Functionality


  Scenario: Check login is successful with valid credentials as role "bendahara"
    Given User has opened the browser
    And User navigates to the login page with url "http://ptbsp.ddns.net:6882"
    When User enters username "bendahara" and password "admin123"
    And User clicks on login button
    Then User is navigated to the dashboard page
    And User should be able to see navigation bar for bendahara


  Scenario: Check login is unsuccessful with invalid username
    Given User has opened the browser
    And User navigates to the login page with url "http://ptbsp.ddns.net:6882"
    When User enters username "indra" and password "admin123"
    And User clicks on login button
    Then User should be able to see unsuccessful login notification message : Incorrect username or password, please try again!