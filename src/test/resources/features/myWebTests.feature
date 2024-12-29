Feature: test google features
  Scenario: Search some phone and check him
    Given I load allo page
    Given I accept cookies if i need it
    Given I search searchbox and enter "IPhone 16"
    Given I press searchbutton
    Given I click to phone title
    Given I search phone name
    Given I search phone price
    Given I check availability of the phone in the database
    Then I put phone and his price in DB
    And I update price of new phone
