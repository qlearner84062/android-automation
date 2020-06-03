Feature: doTERRA Mobile App Android
  As a user I should be able to authenicate and existing user with ID and password

  Scenario Outline: Authenticate existing user with ID and password
    Given I successfully lanuched Mobile application
    And I am on the Shop page where I can browse all products
    When I click on ACCOUNT icon and navigate to Login page
    Then I should see Login page with disabled Log in button
    When I enter my user's <id> and <password> 
    Then I should see Log in button become enabled
    When I click on Log in button
    Then I should see User Account page
    When I click on My Details card
    Then I should be able to validate authenticated user <fullName> and <id>
    When I click on BAG icon
    Then my shopping bag should be empty
    When I click on Start Shopping button
    Then I should be able to see my user's <rewardPoints>
    When I navigate back to User Account page
    Then I should be able to log out my user
    
    Examples: 
      | id      | password                 | fullName    | rewardPoints |
      | 8111537 | VL+i8NsHPUhDiyVo8sB+5w== | Lucas Pinto | 700.00       | 