Feature: SauceDemo Product Order Flow

  @E2EOrder @Smoke
  Scenario: Complete end-to-end product purchase flow
    Given I login successfully as a standard user
    When I add "Sauce Labs Backpack" to the cart
    And I proceed to checkout
    And I enter checkout information "John" "Doe" "12345"
    And I complete the purchase
    Then I should see order confirmation message

  @CartOperations @Regression
  Scenario: Add and remove product from cart
    Given I login successfully as a standard user
    When I add "Sauce Labs Backpack" to the cart
    Then the cart should show "1" items
    When I remove the product from cart
    Then the cart should be empty