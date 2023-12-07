@LoginFeature
@all
Feature: Login User Feature

  Scenario: Check if application is Up and Running
    Given Navigate to the website
    Then Should be able to see landing page

  Scenario: User should not login with out username and password
    Given Navigate to the website
    When I click on login button
    Then Should get field error message for username
    And Should get field error message for password

  Scenario: User should get error message as required if no username and password provided
    Given Navigate to the website
    When I click on login button
    Then Should get error message for username as "Please enter email Id"
    And Should get error message for password as "Please enter password"

  Scenario: User should not be able login without password
    Given Navigate to the website
    When I enter username "useremail@gmail.com"
    When I click on login button
    Then Should get field error message for password

  Scenario: User should not be able login without username
    Given Navigate to the website
    When I enter password "000000000"
    When I click on login button
    Then Should get field error message for username

  Scenario: User should get error message as not valid if username and password are not valid
    Given Navigate to the website
    When I enter username "usernameemail"
    And I enter password "12345"
    When I click on login button
    Then Should get error message for username as "Please enter valid email Id"
    And Should get error message for password as "Password must be at least 8 characters"

  Scenario: User should able to login and logout successfully
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: User should not redirect to login upon successful login
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    And Refresh page and check same page
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: User should be locked if more than 3 failed attempts to login
    Given Navigate to the website
    When I enter username "venkatasai02468@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should get login error message

  Scenario: User should get error message if not registered and try to login
    Given Navigate to the website
    When I enter username "user@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should get login error message

  Scenario: User should not be able to navigate to home page without login by force
    Given Navigate to the website
    When I update url to "home"
    Then Should navigate to login page

 