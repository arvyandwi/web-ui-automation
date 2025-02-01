@login
Feature: Login

  @valid-login
  Scenario: Login with valid username and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is in homepage

  @invalid-login
  Scenario: Login with invalid username and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "invalid"
    When user click login button
    Then user able to see error "Epic sadface: Username and password do not match any user in this service"