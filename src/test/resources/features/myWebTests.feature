Feature: Web test features

 //Scenario Outline: Search some phone and check him
 //   Given I load allo page
 //   Given I accept cookies if i need it
 //   Given I search searchbox and enter <PHONES>
 //   Given I press searchbutton
 //   Given I click to title
 //   Given I search phone name
 //   Given I search phone price
 //   Given I check availability of the phone in the database
 //   Then I put phone and his price in DB
 //   And I update price of new phone
 //   Examples:
 //  |PHONES|
 //  |"IPhone 16"|
 //  |"Moto Edge 50"|

 // Scenario Outline: Checking the name of the first product after entering the product name in the search
    //  Given I load allo page
    //  Given I accept cookies if i need it
    //  Given We search searchbox and enter <value>
    //  Given I press searchbutton
    //  Given I click to title
    //  Given I search product name
    //  Given I compare the name with value
  //  Examples:
    //  |value|
     // |"Зарядна станція EcoFlow"|
   //   |"Moto Edge 50"|

 // Scenario Outline: Smoke test of first purchase
   // Given I load allo page
   // Given I accept cookies if i need it
  //  Given We search searchbox and enter <value>
  //  Given I press searchbutton
  //  Given I click to title
   // Given I click the buy button
  //  Given I click the buy now button
    //Given I search numberbox and enter "637116285"
  //  Given I search box of first name and enter "Марина"
  //  Given I search box of last name and enter "Абдурашитова"
   // Given I click the delivery button
   // Examples:
   // |value|
   // |"Xiaomi 14T"|

 // Scenario: Choosing the cheapest Iphone 16 pro max
  //  Given I load allo page
  //  Given I accept cookies if i need it
  //  Given I click to catalog button
  //  Given I click to smartphones and phones
  //  Given I click to the Apple button
  //  Given I choose the series of the phone
  //  Given I click to IPhone 16 Pro Max check box
  //  Given I filter from cheap to expensive
 //   Given I print the name of chipest phone
Scenario:Check name and price
  Given I load SwegLabs page
  Given I put my name "standard_user"
  Given I put my password "secret_sauce"
  Given I press the login button
  Given I sort the goods
  Given I get title name
  Given I get title price
  Given I click to Title
  Given I get name in details
  Given I get price in details
  Given I compare values
  Given I add to cart
  Given I get counter value
  Given I compare counter value and "1"
  Given I go to the cart
  Given I get name in the cart
  Given I get price in the cart
  Given I compare values in the cart