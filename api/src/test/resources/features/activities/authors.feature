Feature: Authors

  Scenario: Successful get Authors
    Given the user gets all users first and last names

  Scenario: Successful get Authors last name by ID
    Given the user is get author last name for id = 3

  Scenario: Successful create an Author
    Given the user is created author with id = 777
    And the idBook is = 20
    And the first name is "Al"
    And the last name is "Capone"
    Then the user is creating author using parameters above