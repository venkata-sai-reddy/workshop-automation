@WorkshopFeature
@all
Feature: Workshop Feature

  Scenario: User should see all workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When I click on workshop
    And I click on view
    Then Should navigate to workshops page
    When User avatar is clicked on home page
    Then Logout is clicked on home page
    
  Scenario: User should able to request workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When I click on workshop
    And I click on request workshop
    Then Request workshop page should pop up
    And I enter request skills "skill0"
    And I click on request
    Then Request should successful
    When I click on activity
    And I click on requested skills
    Then I should able to see the requested skills "skill0"
    When User avatar is clicked on home page
    Then Logout is clicked on home page


  Scenario: User should able to see the enrolled workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When I click on activity
    And I click on enrolled skills
    Then I should able to see the enrolled skills
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: User should able to unenrolled the workshop
    Given Navigate to the website
    When I enter username "venkatasai1478@gmail.com"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When I click on activity
    And I click on enrolled skills
    Then I should able to see the enrolled skills
    When I click on first enrolled workshop
    When I click on unenroll icon
    Then Should be unenrolled successfully with icon
    When I update url to "logout"
    Then Should navigate to login page

  Scenario: Instructor should able to create workshop
    Given Navigate to the website
    When I enter username "vpunnam@clarku.edu"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When I click on workshop
    And I click on create
    Then Should navigate to create workshops page
    When I fill workshop name "workshop name"
    And I fill workshop description "description..."
    And I select workshop skills
    And I select venue
    And I fill workshop date
    And I fill workshop start time
    And I fill workshop end time
    And I click on create workshop
    When User avatar is clicked on home page
    Then Logout is clicked on home page

  Scenario: Instructor should able to edit workshop
    Given Navigate to the website
    When I enter username "vpunnam@clarku.edu"
    And I enter password "Testing!1"
    When I click on login button
    Then Should navigate to home page
    When I click on workshop
    And I click on view
    Then Should navigate to workshops page
    When I click on first workshop
    And I should able to see the edit icon
    When User avatar is clicked on home page
    Then Logout is clicked on home page
  