Feature: Admin Search Functionality

Scenario: Find user
  Given the user is on the login page
  When the user enters a valid username and password
  And the user clicks the login button
  Then the user should be logged in
  When the user clicks admin menu section
  And the admin enters username in the search field "admin"
  And the admin clicks searchBox
  Then there should be record found
