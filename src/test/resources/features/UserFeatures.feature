@UserFeature
@all
Feature: User Feature

  Scenario: User should able to see his user details
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When User avatar is clicked on home page
    And Profile is clicked on home page
    Then User Profile should display
    When User avatar is clicked on home page
    Then Logout is clicked on home page
