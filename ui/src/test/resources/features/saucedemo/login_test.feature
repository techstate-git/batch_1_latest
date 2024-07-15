Feature: Login Functionality

  Scenario Outline: Login with different users
    Given the user is on the login page [SauceDemo]
    When the user is login in using "<usernames>"
    And the user is enter password
    And the user clicks the login button [SauceDemo]
    Then the user should be logged in [SauceDemo]
    Examples:
      | usernames               |
      | standard_user           |
      | locked_out_user         |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |

  Scenario: Successful Login with Valid Credentials
    Given the user is on the login page [SauceDemo]
    When the user enters a valid username and password [SauceDemo]
    And the user clicks the login button [SauceDemo]
    Then the user should be logged in [SauceDemo]