Feature: Activities

  Scenario: Successful get Activity
    Given the user is get activities

  Scenario: Successful get Activity by ID
    Given the user is get activity by id = 3

  Scenario: Successful create Activity
    Given the user is created activity with id = 777
    And the title is = "TechState"
    And the due date is = 30 days
    And activity is completed = true
    Then the user is creating activity using parameters above
