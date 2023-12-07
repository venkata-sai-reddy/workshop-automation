@SignUpFeature
@all
Feature: SignUp User Feature

  Scenario: User Should Successfully SignUp
    Given Navigate to the website
    When I click on Signup link
    And Fill first name "first name" and last name "last name"
    And Fill email id "test1@testing.com"
    And Fill phone number "7740001111"
    And Fill passwords "Testing@1"
    Then I click on SignUp button
    Then Successfully should signup
  
  Scenario: Instructor user should successfully SignUp
    Given Navigate to the website
    When I click on Signup link
    And Fill first name "first name" and last name "last name"
    And Fill email id "test2@testing.com"
    And Fill phone number "7740001111"
    And Select instructor
    And Select skills
    And Fill passwords "Testing@1"
    Then I click on SignUp button
    Then Successfully should signup

  Scenario: User Should not be able to SignUp with blank fields
    Given Navigate to the website
    When I click on Signup link
    Then I click on SignUp button
    Then Get fields "firstName-helper-text" required error "First Name is required"

  Scenario: User should not signup with same email already used
    Given Navigate to the website
    When I click on Signup link
    And Fill first name "first name" and last name "last name"
    And Fill email id "test2@testing.com"
    And Fill passwords "Testing@1"
    Then I click on SignUp button
    Then Get signup user exists error "User Already Exists, Please Sign In"

  Scenario: User should not be able to signup without password
    Given Navigate to the website
    When I click on Signup link
    And Fill first name "first name" and last name "last name"
    And Fill email id "test2@testing.com"
    And Fill phone number "7741110000"
    And Select instructor
    And Select skills
    Then I click on SignUp button
    Then Get fields "createPassword-helper-text" required error "Create Password is required"

  Scenario: User should be able to signup without optional fields
    Given Navigate to the website
    When I click on Signup link
    And Fill first name "first name" and last name "last name"
    And Fill email id "test3@testing.com"
    And Fill passwords "Testing@1"
    Then I click on SignUp button
    Then Successfully should signup
