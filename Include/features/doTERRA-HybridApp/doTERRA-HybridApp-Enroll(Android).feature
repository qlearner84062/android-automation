Feature: doTERRA Hybrid App Android
  As a user I want to be able to access doTERRA Android app with all of its features

  Scenario Outline: Enrollment flow for Canada region
    Given I am on Eroll screen and click on Enroll today button
    And I have selected my <region> region
    When I switch my warehouse and add individual product to my shopping bag
    Then I should see Shopping Bag screen with Product Guide and individual product
    When I click on Proceed to Checkout button
    Then I should see Account Setup screen
    And I should be able to enter my Personal Details

    Examples: 
      | region  |
      | Canada  |