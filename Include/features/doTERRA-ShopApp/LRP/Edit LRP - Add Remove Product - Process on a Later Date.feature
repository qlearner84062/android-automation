Feature: LRP
  As as user I want to be able to edit LRP order, add/remove product, and process my order

  Scenario Outline: Edit LRP - Add/Remove Product - Process on a Later Date
    Given I successfully lanuched Mobile application
    And I have successfully authenticated my <userName> with <id> and <password>
    When I click on SHOP icon
    And I edit my Scheduled Loyalty Order and add <product> product
    When I click on Save and Process on button   
    Then I should see Order Confirmation screen
    When I click on Back to Home button
    Then I should see Scheduled Loyalty Order with added product
    When I edit my Scheduled Loyalty Order and and change added product quantity to zero
    Then I should see Order Confirmation screen
    And I should see added product being removed from Scheduled Loyalty Order
    
    
    Examples: 
      | id      | password                 | userName    | product            |
      | 8111537 | VL+i8NsHPUhDiyVo8sB+5w== | Lucas       | OnGuard + Softgels |