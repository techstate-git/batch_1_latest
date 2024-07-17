Feature: booker herokuapp testing

  Background: Auth - CreateToken
    Given the user is able to generate token

  Scenario: User is able to retrieve the Booking by ID
    Given the user is successfully retrieve Booking by ID
    Then the user is able to update the Booking