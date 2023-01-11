Feature: Amazon Website Tests

  @DeliverTo @TopBar @HT
  Scenario: Changing Deliver To option
    Given User opens up the Amazon Home Page
    When User clicks on Deliver To on Home Page, Deliver To module is opened
    And User selects delivery to Barbados in Deliver To module and clicks Done
    Then User Deliver To option, on Home Page is set to Barbados

  @LoginNegative @TopBar
  Scenario Outline: Login with incorrect credentials
    Given User opens up the Amazon Home Page
    When User selects Sign In option on the Home Page
    And On the Sign In page, the user introduces incorrect <email> to Email or Phone Nr field
    Then User gets error message We cannot find an account with that email address on Sign In page
    Examples:
      | email                |
      | 0274922379@yahoo.com |
      | tamasnna@yahoo.com   |
      | emailOrPhoneNr       |
      | qwerty@qwerty.ro     |

  @AddProduct @TopBar @HT
  Scenario: Add a Laptop product to the cart
    Given User opens up the Amazon Home Page
    When User searches for keyboards and is sent to the Search Result page
    And On the Search Result page, the User selects a product and is redirected to the Product page
    And User adds a product to the cart from the Product page
    Then The amount of products in the cart should be updated to 1