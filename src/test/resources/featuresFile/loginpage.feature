Feature: Login functionality

  Background:
    Given I am on the OrangeHRM HRM Login Page

  Scenario: Successfully logging with valid credentials
    Given I enter login credentials of the application
    When I click on login btn
    Then I should be logged in successfully

  Scenario Outline: login error with invalid credentials
    Given I enter invalid "<Username>" and "<Password>"
    When I click on login btn
    Then I should see an ErrorMsg
    Examples:
      | Username | Password |
      | admin    | 1111     |
      | John     | john123  |
      | Admin    | admin    |
      | Shreyash | admin123 |


  Scenario: Validating HomePage Elements
    Given I enter login credentials of the application
    When I click on login btn
    Then I should be able to validate Homepage Elements successfully

