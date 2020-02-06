# Module 1 Capstone - Catering System Software

You’ve been asked to develop an application for a Catering Vendor, Weyland Corporation.  

They’re releasing a new application that can be integrated with the customer’s bank accounts allowing customers to order catering products from their computers.


## Application Requirements


1. The catering system needs to track beverages, entrees, appetizers, and desserts.

    - Each catering item has a Name and Price.

2. A main menu should display when the software is run presenting the following options:

        
        (1) Display Catering Items
        (2) Order
        (3) Quit
        
3. Catering inventory is stocked via an input file.
4. The catering system is automatically restocked each time the application runs.
5. When the customer selects ​(1) Display Catering Items its quantity remaining.
    - Each catering product has a product code identifier and a purchase price.
    - Each item in the catering system has enough room for 50 of that product.
    - Every product is initially stocked to the maximum amount.
    - A product which has run out should indicate it is SOLD OUT.
6. When the customer selects (2) Order they are guided through the purchasing process menu:

        
        (1) Add Money
        (2) Select Products
        (3) Complete Transaction
        Current Account Balance: $20.00


7. The purchase process flow is as follows
  - Selecting (1) Add Money ​A customer can repeatedly feed money into the machine in any whole dollar amounts up to $5000 (e.g. $1, $3, $5, $15, $20, $100, etc.)
    - The Current Account Balance should not be able to exceed $5000 at any time
    - Customers should be able to add money multiple times so they can replenish their balance at any time, provided they never go above $5000. 
    - The Current Account Balance indicates how much money the customer has available in their account.
  - Selecting ​(2) Select Product ​allows the customer to select a product and amount to add to their cart.
      - If the product code does not exist, the customer is informed and returned to the Purchase menu.
    - If a product is sold out, the customer is informed and returned to the Purchase menu.
    - If not enough of the product is in stock for the amount the customer requested then they should be informed there is insufficient stock.  
    - If a valid product is selected it is added to the customer cart..
    - After the product is added to the cart, the balance should be updated accordingly and the customer returned to the Order menu.
  - Selecting ​(3) Complete Transaction​ allows the customer to complete the transaction and receive a report of the products they ordered and any remaining change back.
      - The customer’s money is returned using nickels, dimes, quarters, ones, fives, tens, and twenties. (using the smallest amount of bills and coins possible).
    - The customer’s current balance should be updated to $0 remaining.
    - A report should be displayed that shows the items ordered, the amount of each item, the total cost for those items, and the total amount for the order. 

    **<span style="text-decoration:underline;">EXAMPLE ON SCREEN REPORT</span>**



            10 	Beverage   Cola           $1.50 	$15.00	 	
            2	Beverage   White wine	  $3.25		$6.50	
            12	Entree	   Chicken	  $8.50		$102.00
            12	Dessert	   Cake		  $2.25		$27.00

            Total: $150.50



    - After the Transaction is completed the customer should be returned to the main menu and the application should continue to run until the user selects to Quit.   


  8. All purchases must be audited to track orders and amounts in the catering system
      - Each purchase should generate a line in a file called ​Log.txt
      - The audit entry should include the date, time, action taken, and new customer balance 
      - Actions Taken may be:
        - ADD MONEY
        - GIVE CHANGE
        - NUMBER_ORDERED  PRODUCT_NAME  PRODUCT_CODE
      - The audit entries should be in the format:
```
        01/01/2019 12:00:00 PM ADD MONEY: $500.00 $500.00
        01/01/2019 12:00:15 PM ADD MONEY: $250.00 $750.00
        01/01/2019 12:00:20 PM 15 Chicken E4 $112.50 $637.50
        01/01/2019 12:01:25 PM 9 Red Wine B2 $29.25 $608.25
        01/01/2019 12:01:35 PM GIVE CHANGE: $608.25 $0.00
```



## Unit Tests

Unit tests are required to demonstrate that the catering system works as expected.


## Catering System Data File

The input file that stocks the catering system  products is a pipe (|) delimited file. Each line is a

separate product in the file and follows the below format.  

**<span style="text-decoration:underline;">Columns:</span>**

```
Code|Name|Price|Type
```

*   **Product Code:**  The product code used to identify the product when ordering.
*   **Product Name:** The display name of the catering system product.
*   **Price:** The purchase price for the product.
*   **Product Type:** The type of the item:  B (beverage), E (entree), (A) appetizer, (D) dessert.

An example input file has been provided in your repository.  This input file is an example of what an inventory file will look like and while it should be used for development, it may not be the final file used with the system when released.  


## Total System Sales Report (Bonus Requirement)

The total system sales report file is pipe-delimited for consistency and should be written to a file named TotalSales.rpt

Each line is a separate product with the total number and amount sold for the applicable product. 

At the end of the report is a blank line followed by **TOTAL SALES** $dollar amount indicating the gross sales of the catering system.

The Total System Sales Report should be persisted (saved) and not reset when the catering system is restarted.  

**<span style="text-decoration:underline;">Example Total System Sales Report</span>**


```
    Cola|150|$225
    Chicken|211|$1793.50
    Red Wine|18|$58.50
    Cake|73|$164.25

    **TOTAL SALES** $2077.00
```
