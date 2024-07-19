Feature: Validation of post method creating users

  Scenario: Successful creation of a user
    Given the user is preparing a post request "users"
    When the user sends a request to create a user
    Then the user should get created user as a response

