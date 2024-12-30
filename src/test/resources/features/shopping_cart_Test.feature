Feature: This feature file contains all scenarios of shopping cart on amazon.

Scenario: To verify when user added the product in shopping cart succesufully or not 
Given User should Login
When User search tShirt on search box and click on man Tshirt Combo product
And select one Tshirt combo and click on add to cart  
Then verify product is succesufully added to the shopping cart 

Scenario: To Verify user added product in cart and click on plus sign quntity of that product is increases
Given User should Login
When User search tShirt on search box and click on man Tshirt Combo product
And select Another Tshirt combo and click on add to cart 
And Go to cart and check quntity befor and click on plus sign 
Then Verify quntity of product After click on plus sing

Scenario: To Verify user added product in cart and click on subtract sign quntity of that product is decrease
Given User should Login
When User search tShirt on search box and click on man Tshirt Combo product
And select Another Tshirt combo and click on add to cart
And Go to cart and check quntity befor and click on subtract sign 
Then Verify quntity of product is decreases After click on subtract sing

Scenario: To Verify user added Two product in the cart then subTotal of product is increases
Given User should Login
When user added one product in cart and check the SubTotal
And also added second product and go to cart 
Then verify subTotal is Increases After Adding second product 

Scenario: To verify user added same product In Two Times Quntity of product is increase
Given User should Login
When user added one product in cart and check the Quntity
And Also added Same product second time 
Then verify Quntity is increase after adding same product

Scenario: To verify  After adding product i cart product details in the cart is same as product display page  
Given User should Login
When check Product details Before adding product in the shopping cart 
Then Check product details After adding shopping cart

Scenario: To verify product Display Is Same After Refresh Browser page
Given User should Login
When go to cart get name of first product and refresh the page 
Then verify same product is display in page after refreshing 
#7
Scenario: To verify User Click On DeselectAll button No Item Selected Message Is Displayed
Given User should Login
When user go to the cart and click on deselect all
Then verify no Itern select messege is desplay in cart
#8
Scenario: To verify User Click On SelectAll button selected Item count is Displayed
Given User should Login
When user go to the cart and click on Select all
Then verify selected Item count is Displayed in cart
#9
Scenario: To verify user Redirect To Product Details Page After click on product From Shopping Cart
Given User should Login
When user go to shopping cart and click on product
Then verify user redirect to these product details page 
#10
Scenario: verify Save To Later Option Is Dispaly and Enable
Given User should Login
When user go to the cart 
Then verify Save To Later Option Is Dispaly and Enable
#11
Scenario: To verify user Click On See More Like These then Similar Products Page Is Open
Given User should Login
When user go to the cart and click on see more like these 
Then verify similar product page is display
#12
Scenario: To verify user Click On shsre then share to friend Page Is Open
Given User should Login
When user go to the cart and click on share 
Then verify share to friend message is display
#13
Scenario: To verify Click On Save To Later product Is Move To Save To later
Given User should Login
When user go to the cart and click on save To Later 
Then verify product is move to the save to later
#14
Scenario: To verify Click On Add to Shopping List then Product Is Added To Shopping List message is display
Given User should Login
When User go to cart and go to save to later and click on add to shopping cart
Then Product Is Added To Shopping List message is display
#15
Scenario: To verify User Click On Added To Shopping  then Shopping List page is open
Given User should Login
When user go to cart and click on added to shopping list message from save to later 
Then Shopping List page is open
#16
Scenario: To verify User Click On Proceed To By then Checkout Page Is Display 
Given User should Login
When User go to cart and Click On Proceed To By
Then Checkout Page Is Display
#17
Scenario: To verify User Delete One Product From Cart Delete Message Should Be Display
Given User should Login
When User go to cart and click on delete
Then these product delete message is display
#18
Scenario: To verify User Click On Delete Product Message These Product Title Page Is Open
Given User should Login
When user go to cart and click delete product message 
Then verify delete product page is open 
#19
Scenario: To verify all Product Is Remove In cart then Cart Is Empty
Given User should Login
When user go to cart and delete all product in cart 
Then cart is empty message is display
