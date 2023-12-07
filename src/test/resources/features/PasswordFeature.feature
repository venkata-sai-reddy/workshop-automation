@PasswordFeature
@all
Feature: Forget Password feature

  Scenario: Forget Password should be successful
    Given Navigate to the website
    When I click on forget password link
    And I enter emailid "test0@testing.com"
    And I click on forget password button
    Then Should display success message

  Scenario: User should not be able to reset password without email
    Given Navigate to the website
    When I click on forget password link
    And I click on forget password button
    Then Should display field error message "Please enter email Id"

  Scenario: User should not be able to reset password without email
    Given Navigate to the website
    When I click on forget password link
    And I enter emailid "test0"
    And I click on forget password button
    Then Should display field error message "Please enter valid email Id"

  Scenario: User should not be able to reset password with invalid email
    Given Navigate to the website
    When I click on forget password link
    And I enter emailid "test100@testing.com"
    And I click on forget password button
    Then Should display error message "Email Id does not exists, Please check and try again"
