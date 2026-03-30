Feature: Purchase the order from Ecommerce Website


  Background:
    Given I lanndedon Ecommerce Page


  Scenario Outline: Positive Test of submitting the order
    Given I landedon Ecommerce Page
    Given Logged in with username <name> and password <password>
    When I add product <productName>  from Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." messsage is displayed onConfirmation page

    Examples:
      | name             | password | productName |
      | asuman@gmail.com | aSuman@1 | ZARA COAT 3 |
