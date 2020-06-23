Feature: LRP
  As as user I want to be able to edit LRP and process my order

  Scenario Outline: Process on a Later Date - Edit LRP
    Given I successfully lanuched Mobile application
    And I have successfully authenticated my <userName> with <id> and <password>
    When I click on SHOP icon
    And I edit my Scheduled Loyalty Order and click on Save and Process on later date button
    Then I should see Loyalty Order Confirmation screen
    

    Examples: 
      | id      | password                 | userName    |
      | 8111537 | VL+i8NsHPUhDiyVo8sB+5w== | Lucas       |