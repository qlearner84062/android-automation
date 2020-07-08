Feature: LRP
  As as user I should be able to create and delete my LRP

  Scenario Outline: Create and Delete LRP
    Given I successfully lanuched Mobile application
    And I have successfully authenticated my <userName> with <id> and <password>
    When I click on SHOP icon and scroll to LRP section
    Then I should be able to create new LRP and add <product>
    And I should be able to select processing date and verify <phone>, <email>, and delivery address
    When I select my payment method and verify my Order Summary
    And I click on Save and Process Now button
    Then I should see Order Confirmation screen
    When I click on Back to Home button
    Then I should see added LRP order
    When I edit my added LRP order
    Then I should be able to validate <product>, <phone>, <email>, Processing Date, Delivery Address, <paymentMethod>, and Order Summary 
    And I should be able to delete added LRP order
    And I should not be able to delete last LRP order
    
    Examples: 
      | id      | password                 | userName    | product            | phone      | email                                    | paymentMethod    |
      | 8111537 | VL+i8NsHPUhDiyVo8sB+5w== | Lucas       | OnGuard + Softgels | 1234561234 | it.doterratest+8111537-preview@gmail.com | Cash on Delivery |