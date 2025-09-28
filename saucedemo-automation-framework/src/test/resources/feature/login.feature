Feature: SauceDemo Login Functionality

  Background:
    Given I am on the SauceDemo login page

  @ValidLogin @Smoke
  Scenario: Successful login with valid credentials
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be redirected to the products page

  @LockedUser @Regression
  Scenario: Login attempt with locked out user
    When I login with username "locked_out_user" and password "secret_sauce"
    Then I should see error message "Epic sadface: Sorry, this user has been locked out."

  @InvalidLogin @Regression
  Scenario Outline: Login attempts with invalid credentials
    When I login with username "<username>" and password "<password>"
    Then I should see error message "<error_message>"
    
    Examples:
      | username        | password     | error_message                                       |
      | invalid_user    | secret_sauce | Epic sadface: Username and password do not match    |
      | standard_user   | wrong_pass   | Epic sadface: Username and password do not match    |
      | ""              | secret_sauce | Epic sadface: Username is required                  |
      | standard_user   | ""           | Epic sadface: Password is required                  |

  @Navigation @Regression
  Scenario: Verify login page elements are displayed
    Then I should see login page elements