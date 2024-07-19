Feature: Validation for users retrieval
  Scenario: Successful retrieval of multiple users
    Given the user is preparing a url endpoint "users"
    When the user sends a request to server
    Then the user should get collection of users