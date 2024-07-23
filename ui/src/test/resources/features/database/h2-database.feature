Feature: Database operations

  Scenario: Verify data in the database
    Given the database is set up
    When I query the students table
    Then I should see the student with ID 1 and name "John Doe"
    And I should see the student with ID 2 and name "Jane Smith"
    And I print the students table
