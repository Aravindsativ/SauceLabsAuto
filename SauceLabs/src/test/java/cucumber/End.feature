
@tag
Feature: purchase the product from the sauceLab Ecommerce website
	Background:
	Given I landed on Ecommerce Page

  @tag1
  Scenario Outline: Postive test of ordering a product
    Given Logged in with username <name> and password <password>
    When  I add product <productname> to the cart
    And  go to the cart page and click on checkout button
    And enter the cityname <city> statename<state> pincode <pincode> and click on continue button
    And check your details and click on finish button
    Then the thankyou for ordering message should appear
    Examples: 
      | name  			 | password    |       productname          |city |state|pincode|
      | standard_user| secret_sauce|Sauce Labs Fleece Jacket    |heldi|  goa|ldlf|
    
