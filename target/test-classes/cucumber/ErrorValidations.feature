
@tag
Feature: ErrorValidations
  I want to use this template for my feature file

  
@ErrorValidations
  @tag2
  Scenario Outline: Negative test of login
    Given I landed on Ecommerce page
    When logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name              |  value |                    
      | Deeks11@gmail.com |    Dee | 
      
