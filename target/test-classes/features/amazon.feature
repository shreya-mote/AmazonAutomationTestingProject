Feature: This feature file tests all scenario of loginPage of amazon.
#Scenario: To verify when user enter blank email id
#Given Browser is opened and app url is launched
#When User click on signin link
#And Keep EmailId as blank
#And Click on continue button 
#Then Wait for error message to appear
#And Verify error message

Scenario: To verify that product is added to cart succesfully or not.
When User search for product on searchbar
And Select product from suggested list
And click on desired product
And User should navigate to add to cart page,click on add to cart button
Then Verify that product is added into cart or not.
 