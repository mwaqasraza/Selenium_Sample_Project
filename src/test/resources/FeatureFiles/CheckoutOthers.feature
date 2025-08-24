#AuthorName: Murali Krishnan Nagaraj
#AuthorEmail: muralikrishnan.nagaraj@albertsons.com
#Keywords Summary : Checkout Page Validations
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios

#**************************************************#
#  Team wise scenario count breakup
#   Total count:                          2


# ***************************************************#



@Regression @Desktop @DesktopCheckout
Feature: Checkout items and place order

#  Background: Open Browser and navigate to HomePage
#    Given user navigates to HomePage


  @TC_ABS_Commerce_02
  Scenario: Validation user purchases a Grocery product on E-commerce site and place delivery order
    Given I launch the browser
    When I navigate to "https://www.safeway.com"
#    When User navigates to Aisles page from Shop Flyover Menu
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    #Use the Page Class "OnboardingModalPage and "HomePage" for creating elements & action methods.
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
#    And User verifies sidebar menu is opened
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    When User clicks on Sign In in header
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    Then User will wait and verifies "Shopped with us before?" modal popup is displayed
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    When User clicks on Sign in from sidebar menu
    Then User will wait and verifies " Welcome back!" modal popup is displayed
    And User Enters "msami@nisum.com" Email ID
    When User clicks on Sign in with password
    #Then User will wait and verifies "Sign in with password" modal popup is displayed
    #And User Enters "abc123" Password
    #When User clicks on Sign In
    #Use the Page Class "SignInPage" for creating elements & action methods.
    #Use the Step Definitions Class "SignInPageSteps" for creating step definitions.
    #Then User will wait until 5100 Broadway is clickable and user will Clicks on it
    #Use the Page Classes "SignInPage" and "HomePage" for creating elements & action methods.
    #Use the Step Definitions Class "SignInPageSteps" for creating step definitions.
#    And User Verifies "/www" Page is displayed
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
#    When User clicks StoreAddress on Home Page
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Element - "StoreModel.StoreAddress" By xpath - //div[@id='openFulfillmentModalButton']
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    #Then User will wait and verifies " Find a Store near you, or shop for Delivery or Pickup. " modal popup is displayed
    #And  User enters ZIP Code "94566" in ZipCode field
    #When User clicks Search button
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Enter the ZipCode in the text box and click on SearchIcon 0n Store Model using the below elements
    #Element - ZipCode - By xpath - //*[@aria-labelledby='zipcode']
    #Element - SearchIcon - By xpath - //span[@aria-label='search Zipcode']
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    #And User clicks DeliveryTab
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Element - "StoreModel.DeliveryTab" By xpath - //a[@id='modal-tab-delivery-btn']
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    #And User clicks Select button against any Shop
    #Use the Page Class "HomePage" for creating elements & action methods.
    #Element - By xpath - //a[text()=' Shop ']
    #Use explicit wait on element to be clickable
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    Then User will wait until search field on homepage is interactable
    #Use the Step Definitions Class "HomePageSteps" for creating step definitions.
    #validate title of home page "Grocery Delivery Near You - Order Groceries Online | Safeway"
    When User enter "milk" in search field and press enter key
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
    #for input field - search.searchBox - Use the locator - By xpath - //*[@name='q']
    #for search field - search.searchButton - Use the locator - By xpath - //*[@aria-label='search']
    #enter text in the search box and click the button
    Then User will wait and verify that the user sees searched items on the Products Page
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Element - By xpath - //*[@data-qa='prd-itm']
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
    When User clicks on the first item Add Button from the Products Page
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Element - By xpath - //*[@data-qa='prd-itm'][1]//span[text()='Add']
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
    When User Clicks Cart Icon in Header
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
#    Then User Verifies Mini Cart Layout Is Displayed
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
#    And User Verifies "FULL CART" Button Is Displayed In Mini Cart
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
#    And User Verifies "CHECK OUT" Button Is Displayed In Mini Cart
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
#    And User Verifies 'Remove' Buttons Are Displayed In Mini Cart
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
#    And User Verifies All Added Items Are Displayed In Mini Cart
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
#    And User Verifies Order Summary in Mini Cart
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
    When User will wait until checkout button is clickable and clicks Checkout Button under cart sidebar
    #Use the Page Class "ProductsPage" for creating elements & action methods.
    # Button- xpath - //button containing text 'Checkout'
    #Use the Step Definitions Class "ProductsPageSteps" for creating step definitions.
    When User will wait until order info page is displayed
    And  User enters valid AddressDetails details on Checkout Page using following details
      | FirstName | LastName | StreetAddress       | ZIPCODE |
      | Anna      | Clark    | 1701 Santa Rita RD | 94566   |
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
    #Fill the Address details on Checkout page with the given info in the cucumber data table
    #Element - Text Box - FirstName - //input[@name="firstName"]
    #Element - Text Box -  LastName - //input[@id="lastName"]
    #Element - Text Box -  AddressLine1 - //input[@id='streetAddress']
    #Element - Text Box -  ZipCode - //input[@id='zipCode']
    And User will wait for a while and clicks Continue Button on Checkout Page
#    And User clicks Continue Button on Checkout Page
    And User clicks second Continue Button on Checkout Page
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Button- xpath - //button containing text 'Continue'
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
    When User will wait and Selects fastest delivery time
#    And User clicks second Continue Button on Checkout Page
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
#    When User Verifies "1" Hour Timeslots with view more option is Displayed
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
#    And User Clicks Continue Button In Reserve Time Slot Section
    And User clicks third Continue Button on Checkout Page
    And Execution completed
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
#    And User Verifies Order Summary is Displayed
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
#    And User Validates Item Preferences Section
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
#    And User Clicks Continue Button In Item Preferences Section
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
#    And User Verifies Green Tick Mark in the "Item Preferences" section
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions.
#    And User Verifies PromoCode tab is Enabled
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions
#    When User Enters Payment Details
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions
#    And User Clicks Place Order Button
    #Use the Page Class "CheckoutPage" for creating elements & action methods.
    #Use the Step Definitions Class "CheckoutPageSteps" for creating step definitions
#    Then Verify that the user is navigated to the OrderConfirmation Page
    #Use the Page Class "OrderConformationPage" for creating elements & action methods.
    #Element - "OrderConfirmation.Title" By xpath - //h1[text()='Order Confirmation']
    #Use explicit wait to check visibility of element located
    #Use the Step Definitions Class "OrderConformationPageSteps" for creating step definitions



  @StageTest
  Scenario Outline: Verify delivery order placement for registered order
    When User Clicks Sign In Up link in header
    And User verifies sidebar menu is opened
    When User clicks on "Create Account" from sidebar menu
    Then User verifies "Create Account" modal popup is displayed
    And Verify Create Account Button is "Disabled"
    When User enters valid data in all the fields of Registration modal popup
    When User Clicks I Agree checkbox in Registration Page
    Then Verify Create Account Button is "Enabled"
    And Click on CreateAccount button in the Registration Page
    Then User Verifies The Zip Code Modal Window Is Displayed
    When User Selects "Delivery Address" as Preference
    Then User verifies "delivery" is present in the reserve navigation container
    When User navigates to Aisles page from Shop Flyover Menu
    Then User Verifies "/aisles" Page is displayed
    When User Clicks On "Specific" Category From Aisles Page
    Then User Verifies "Specific" Category Page Is Displayed
    When User Clicks On "Specific" subcategory From Category Page
    Then User Verifies Products Page is Displayed
    When User Clicks 'Add' button On Products Page

    And User Updates Product Quantity As 19
    Then User Verifies Cart Count Is 19
    And User Verifies Incrementer & Decrementer Is Displayed For the Added Product
    When User Clicks Cart Icon in Header
    Then User Verifies Mini Cart Layout Is Displayed
    And User Verifies "FULL CART" Button Is Displayed In Mini Cart
    And User Verifies "CHECK OUT" Button Is Displayed In Mini Cart
    And User Verifies 'Remove' Buttons Are Displayed In Mini Cart
    And User Verifies All Added Items Are Displayed In Mini Cart
    And User Verifies Order Summary in Mini Cart
    When User Clicks on Full Cart Button From Mini Cart

    Then User Verifies "/erums/cart" Page is displayed
    And User Verifies All Added Items Are Displayed In Full Cart
    And User Verifies Subtotal in Full Cart
    When User Clicks on Checkout Button From Full Cart
    Then User Verifies "/erums/checkout" Page is displayed
    And User Verifies Subtotal in CheckoutPage

    When User Enters "Residential Address" as delivery address
    And User Clicks Continue Button In Order Info Section
    Then User Verifies First Name and Last Name are displayed in the Order Info Section in edit mode
    When User Enters Contact Number In Order Info Section
    And User Clicks Continue Button In Order Info Section
    Then User Verifies Green Tick Mark in the "Order Info" section


    When User Selects 1 Hour Time Slot
    When User Verifies "1 2 and 4" Hour Timeslots with view more option is Displayed
    And User Clicks Continue Button In Reserve Time Slot Section
    And User Verifies Green Tick Mark in the "Delivery Date and Time" section

    And User Verifies Order Summary is Displayed

    And User Validates Item Preferences Section
    And User Validates Items Count For the Selected Item Preference
    And User Clicks Continue Button In Item Preferences Section
    And User Verifies Green Tick Mark in the "Item Preferences" section

    And User Verifies PromoCode tab is Enabled

    When User Selects 2 Hour Time Slot
    And User Clicks Continue Button In Reserve Time Slot Section
    And User Verifies Green Tick Mark in the "Delivery Date and Time" section

#    And User Validates Item Preferences Section
#    And User Validates Items Count For the Selected Item Preference
#    And User Clicks Continue Button In Item Preferences Section
#    And User Verifies Green Tick Mark in the "Item Preferences" section
    And User Verifies PromoCode tab is Enabled

    When User adds promo code "<Promo Code>"
    When Verify added promo code "<Promo Code>" in Promo code and payment section
    And Verify added promo code description "<Promo Code Description>" in Promo code and payment section
    Then User verifies promo code is added to order summary section
    And User Verifies Subtotal in CheckoutPage

    When User Enters Payment Details
    And User Clicks Place Order Button
    Then User Verifies Order Conformation Page is Displayed
    Then User verifies promo code is displayed in the order summary section
    Then Verify amount "<Promo Amount>" is displayed in Order Confirmation Page
#    When User Clicks MyOrders Links in Order Conformation Page
    When User Clicks on Account Profile Dropdown In Header
    When User clicks on "Orders" from sidebar menu
    Then User Verifies "/order-account/orders" Page is displayed
#    Then User Verifies Order Number Is Displayed

    When User Clicks "cancel order" button in Orders Page
    Then User Verifies "cancel order" page is displayed
    Then User clicks "cancel order" from popup
    Then User verifies the cancelled order is displaying as canceled in orders page

    Examples:
      | Promo Code | Promo Amount | Promo Code Description                                                                                                                         |
      | SAVE20     | -$20.00      | $20 Off + Free Delivery on your first online order of $75 or more. This offer may not be combined with any other offer. Limit 1 per household. |

  @StageTest
  Scenario: Verify registered user can place DUG order
    When User navigates to Aisles page from Shop Flyover Menu
    Then User Verifies "/aisles" Page is displayed
    When User Clicks Sign In Up link in header
    And User verifies sidebar menu is opened
    When User clicks on "Sign In" from sidebar menu
    Then User verifies "Sign In" modal popup is displayed
    And User Enters "DUG" Email ID and Password
    Then User Clicks Submit Button
    #Then User Verifies "welcome/delivery-preference" Page is displayed
    #When User Selects "DUG" as Preference
    And User Verifies "/www" Page is displayed
    And User changes delivery preference if not already selected as "pickUp"
    And User verifies "pickUp" is present in the reserve navigation container

    When User Removes All Items From Shopping Cart
    When User navigates to Aisles page from Shop Flyover Menu
    Then User Verifies "/aisles" Page is displayed

    When User Clicks On "Specific" Category From Aisles Page
    Then User Verifies "Specific" Category Page Is Displayed
#    When User Clicks On "any" subcategory From Category Page
    When User Clicks On "Specific" subcategory From Category Page
    Then User Verifies Products Page is Displayed

    When User Clicks 'Add' button On Products Page
#    And User Updates Product Quantity As 35
#    Then User Verifies Cart Count Is 35
    And User Updates Product Quantity As 9
    Then User Verifies Cart Count Is 9
    And User Verifies Cart Price Is Greater Than 0
    And User Verifies Incrementer & Decrementer Is Displayed For the Added Product

    When User Clicks Cart Icon in Header
    Then User Verifies Mini Cart Layout Is Displayed
    And User Verifies "FULL CART" Button Is Displayed In Mini Cart
    And User Verifies "CHECK OUT" Button Is Displayed In Mini Cart
    And User Verifies 'Remove' Buttons Are Displayed In Mini Cart
    And User Verifies All Added Items Are Displayed In Mini Cart

    And User Verifies Order Summary in Mini Cart

    When User Clicks on Full Cart Button From Mini Cart
    Then User Verifies "/erums/cart" Page is displayed
    And User Verifies All Added Items Are Displayed In Full Cart
    And User Verifies Subtotal in Full Cart
    When User Clicks on Checkout Button From Full Cart
    Then User Verifies "/erums/checkout" Page is displayed
    And User Verifies Subtotal in CheckoutPage

    Then User Verifies First Name and Last Name are displayed in the Order Info Section in edit mode
    And User Verifies Delivery Address is displayed in the Order Info Section
    When User Enters Contact Number In Order Info Section
    And User Clicks Continue Button In Order Info Section
    And User Verifies Green Tick Mark in the "Order Info" section

    When User Selects 1 Hour Time Slot
    When User Verifies "1" Hour Timeslots with view more option is Displayed
    And User Clicks Continue Button In Reserve Time Slot Section
    And User Verifies Green Tick Mark in the "PickUp Date and Time" section
    And User Verifies Order Summary is Displayed

    And User Validates Item Preferences Section
    And User Clicks Continue Button In Item Preferences Section
    And User Verifies Green Tick Mark in the "Item Preferences" section
    And User Verifies PromoCode tab is Enabled
    When User Enters Payment Details
    And User Clicks Place Order Button
    Then User Verifies Order Conformation Page is Displayed
#    When User Clicks MyOrders Links in Order Conformation Page
#    Then User Verifies Order Number Is Displayed

