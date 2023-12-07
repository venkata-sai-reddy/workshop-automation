@AdminFeature
@all
Feature: Admin Feature

  Scenario: Admin should able to see all users
    Given Navigate to the website
    When I enter username "workshopapplicationcu@gmail.com"
    And I enter password "Admin@123"
    When I click on login button
    Then Should navigate to home page
    And Check welcome message displayed
    When I click on Users
    And I click on All Users
    Then Should able to see all the users
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: Admin should able to create users
    Given Navigate to the website
    When I enter username "workshopapplicationcu@gmail.com"
    And I enter password "Admin@123"
    When I click on login button
    Then Should navigate to home page
    And Check welcome message displayed
    When I click on Users
    And I click on create user
    Then Should able to see create user page
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: Admin should able to see all skills
    Given Navigate to the website
    When I enter username "workshopapplicationcu@gmail.com"
    And I enter password "Admin@123"
    When I click on login button
    Then Should navigate to home page
    And Check welcome message displayed
    When I click on Skills
    And I click on All Skills
    Then Should able to see all the skills
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: Admin should able to see all requested skills
    Given Navigate to the website
    When I enter username "workshopapplicationcu@gmail.com"
    And I enter password "Admin@123"
    When I click on login button
    Then Should navigate to home page
    And Check welcome message displayed
    When I click on Skills
    And I click on All Requested Skills
    Then Should able to see all the requested skills
    When User avatar is clicked on home page
    Then Logout is clicked on home page

