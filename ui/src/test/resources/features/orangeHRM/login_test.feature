Feature: Login Functionality

  Scenario: Successful Login with Valid Credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the user should be logged in

  Scenario: Unsuccessful Login with Invalid Credentials
    Given the user is on the login page
    When the user enters an invalid username and password
    And the user clicks the login button
    Then the user should not be logged in

  Scenario: Login to https://www.saucedemo.com/
    Given the user is on the sauceDemo login page
    When the user enters a valid username and password for the sauceDemo
    And the user clicks the login button in SauceDemo
    Then the user successfully logs in





