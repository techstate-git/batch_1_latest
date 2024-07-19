Feature: Validation for single user retrieval

  Scenario: Successful retrieval of single user
    Given the user prepares a url endpoint with id "users/1"
    When the user sends a request
    Then the user should get a correct response


  Scenario: Negative retrieval of single user









