Feature: Logout Functionality

  Background:
    Given User has opened the browser
    And User navigates to the login page with url "http://ptbsp.ddns.net:6882"
    And User enters username "bendahara" and password "admin123"
    And User clicks on login button

  @Positive @TC04
  Scenario: Check logout is successfull and redirect to login page    
    When User clicks on the Logout button
    And  User confirms logout by clicking "Ya" button in the confirmation modal
    Then User is redirected to the login page

