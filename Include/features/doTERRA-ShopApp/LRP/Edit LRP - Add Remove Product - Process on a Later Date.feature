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
    Then I should see Scheduled Loyalty Order with added product and <processingDate>
    When I edit my Scheduled Loyalty Order and change added product quantity to zero
    Then I should see Order Confirmation screen
    And I should see added product being removed from Scheduled Loyalty Order with <processingDate>
    
    
    Examples: 
      | id      | password                 | userName | product            | processingDate |
      | 8119743 | VL+i8NsHPUhDiyVo8sB+5w== | Kurtis   | OnGuard + Softgels | Aug 2         |