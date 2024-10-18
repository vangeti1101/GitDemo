
@tag
Feature: purchase order from e-commerce website.
  I want to use this template for my feature file
Background:
Given I landed on Ecommerce page

  @Regression
  Scenario Outline: positive test of submitting the order.
    Given logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout the <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      |       name  					 |     password		 | productName  |
      | Deekshav11@gmail.com   |     Deeksha11@  |  ZARA COAT 3 |
      
