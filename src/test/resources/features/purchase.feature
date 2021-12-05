
@purchase
Feature: purchase product

  Scenario:As a user I should able to purchase.
    Given User is on the homePage
    When  User navigates to "Phones" "Samsung galaxy s6"
    And   User clicks on "Add to cart"
    And   User accepts pop up
    And   User clicks on "Home "
    When  User navigates to "Phones" "Samsung galaxy s7"
    And   User clicks on "Add to cart"
    And   User accepts pop up
    And   User clicks on "Cart"
    And   User deletes "Samsung galaxy s6"
    And   User clicks on "Place Order"
    When  User fills following data
      | name    | Hulya   |
      | country | Spain   |
      | city    | Cordoba |
      | card    | Visa    |
      | month   | 12      |
      | year    | 2021    |

    And  User clicks on "Purchase"
    Then User sees Purchase Id and Purchase Amount
    Then Purchase amount equals expected
    And  User clicks on "OK"

