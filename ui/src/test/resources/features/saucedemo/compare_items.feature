Feature: Compare items from Home Page in the Cart Page

  Scenario: Add item to the cart
    Given the user is on the login page [SauceDemo]
    When the user enters a valid username and password [SauceDemo]
    And the user clicks the login button [SauceDemo]
    Then user is adding to cart items below
      | items                             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Then user clicks on "Sauce Labs Backpack"


