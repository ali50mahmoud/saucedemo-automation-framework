Feature: Simple Books API Testing

  @API @Smoke
  Scenario: API Status Check
    When I check the API status
    Then API status should be "OK"

  @API @Regression
  Scenario: Get list of books
    When I request the list of books
    Then I should receive a list of books

  @API @Regression
  Scenario: Submit a new order with authentication
    Given I have a valid API authentication token
    When I submit a new order for book "1" with customer name "John Doe"
    Then the order should be created successfully
    And I should be able to retrieve the order