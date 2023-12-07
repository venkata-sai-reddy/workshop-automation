@HomeFeature
@all
Feature: Home Feature
  I want to use this template for my feature file

  Scenario: Student user home screen
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    And Check welcome message displayed
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: Instructor user home screen
    Given Navigate to the website
    When I enter username "vpunnam@clarku.edu"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    And Check welcome message displayed
    And Check create workshop displayed
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: Admin user home screen
    Given Navigate to the website
    When I enter username "workshopapplicationcu@gmail.com"
    And I enter password "Admin@123"
    When I click on login button
    Then Should navigate to home page
    And Check welcome message displayed
    And Check admin features displayed
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: User should able to click on view workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When I click on view workshops
    Then Should navigate to workshops page
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: User should able to click on upcoming workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When Upcoming workshops displayed
    And I click on first upcoming workshop
    Then Should navigate to workshop page
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: User should able to see details on upcoming workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When Upcoming workshops displayed
    Then Workshop contains workshop name
    And Workshop contains workshop date
    And Workshop contains workshop location
    And Workshop contains capacity
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: User should able to see enroll status on upcoming workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When Upcoming workshops displayed
    And I click on first upcoming workshop
    Then Should navigate to workshop page
    When I click on enroll button
    Then Should enroll successfully
    When I navigate to Home page
    Then Upcoming workshop should have user enroll status
    When I update url to "logout"
    Then Should navigate to login page
