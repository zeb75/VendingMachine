package entities;
import java.util.ArrayList;
import java.util.List;

import utilities.UserInput;

public class Vm{
	 // Setting for allowed currency values
	 static int[] currencyValues = { 1000, 500, 100, 50, 20, 10, 5, 1 };   
	 
	 // Setting credits to 0
     int credits = 0;
     
     // List to save products in the vending machine
     private List<Product> items = new ArrayList<Product>();
     
     // List to save bought products
     private List<Product> boughtItems = new ArrayList<Product>();   
       

     public void mainMenu()
     {
         boolean keepAlive = true;
         
         
         while (keepAlive)
         {
             System.out.println("\n1 - Deposit" + "\n2 - Shop" + "\n3 - Collect change" + "\n4 - Exit");

             int headMenu = UserInput.getInt();

             switch (headMenu)
             {
             	 // Go to deposit 
                 case 1:                                                                                 
                     deposit();                       								
                     break;

                 // Go to shop menu
                 case 2:                                
                     shopMenu();
                     break;
                 
                 // Go to collect change option
                 case 3:
                     returnChange();                 
                     break;
                     
                 // Exit the program
                 case 4:                               
                     keepAlive = false;
                     break;

                 default:
                     System.out.println("Invalid input");
                     break;
             }
         }
     }

     // Menu for purchasing, examine and using products 
     public void shopMenu()
     {
         boolean keepAlive = true;
         while (keepAlive)
         {
        	 System.out.println("SHOP" + "\n1 - Buy item" + "\n2 - Examine item" + "\n3 - Use item" + "\n4 - Back to main menu");
             int shopMenu = UserInput.getInt();

             switch (shopMenu)
             {
             	 // Buy an item
                 case 1:                                                                        
                     showProducts();
                     checkCredits();
                     buyItem();
                     checkCredits();
                     break;
                     
                 // Examine an item
                 case 2:                                                                                 
                     showProducts();
                     examItem();
                     break;
                     
                 // Look at bought items and use them
                 case 3:                                                                               
                     showBoughtProducts();
                     useItem();
                     break;

                 // Exit to main menu
                 case 4:
                     keepAlive = false;
                     break;

                 default:
                	 System.out.println("Invalid input");
                     break;
             }
         }
     }

     // Method to purchase a product
     public void buyItem()
     {
    	 System.out.println("Select a number and press enter to buy");
         int selection = UserInput.getInt();
         
         // Looping thru the list of products
         for(Product item : items)
         {
        	 // Selecting product by article number
             if (selection == item.getArticleNumber())
             {
            	 // Checking that there is enough credits to buy the product
                 if (credits >= item.getPrice())
                 {
                	 // Adding the product to the bought products list
                     boughtItems.add(item);
                     // Removing the product from the list of products
                     items.remove(item);
                     // Subtracting cost of product from the users credits
                     credits = credits - item.getPrice();
                     System.out.println("You have bought: " + item.getName());
                 }

                 else
                 {
                	 System.out.println("You don´t have enough credits to buy this product");
                 }

                 break;
             }
         }
     }

     // Method to show full information about a product
     public void examItem()
     {
    	 System.out.println("Select a number and press enter to examine the item");
         int selection = UserInput.getInt();

      // Looping thru the list of products
         for(Product item : items)
         {
        	 // Selecting product by article number
             if (selection == item.getArticleNumber())
             {
            	 // Show all information about the selected product
                 item.examine();
             }
         }
     }

     // Method to use a bought product
     public void useItem()
     {
    	 System.out.println("Select a number and press enter to use the item");
         int selection = UserInput.getInt();
         
      // Looping thru the list of bought products
         for(Product item : boughtItems)
         {
        	// Selecting product by article number
             if (selection == item.getArticleNumber())
             {
            	 // Using the selected product
                 item.useItem();
                 // Removing the product from the list of bought products
                 boughtItems.remove(item);
                 break;
             }
         }
     }

     // Method for showing available products in the vending machine
     public void showProducts()
     {
    	 // Looping thru the list of products
         for(Product item : items)
         {
        	 // printing info for each product in the list 
             item.listInfo();
         }
     }

     // Method for showing bought products 
     public void showBoughtProducts()
     {
    	// Looping thru the list of bought products
         for(Product item : boughtItems)
         {
        	// printing info for each product in the list
             item.listInfo();
         }
     }

     // Method to deposit credits
     public void deposit()
     {
         System.out.println("Insert money");

         // Looping thru and printing the valid currency values (set in currencyValues)
         for (int i = 0; i < currencyValues.length; i++)
         {
        	 System.out.println(i + 1 + " = " + currencyValues[i] + "kr");
         }
         int depositMenu = UserInput.getInt();

         switch (depositMenu)
         {
             case 1:
                 credits = credits + 1000;
                 break;

             case 2:
                 credits = credits + 500;
                 break;

             case 3:
                 credits = credits + 100;
                 break;

             case 4:
                 credits = credits + 50;
                 break;

             case 5:
                 credits = credits + 20;
                 break;

             case 6:
                 credits = credits + 10;
                 break;

             case 7:
                 credits = credits + 5;
                 break;

             case 8:
                 credits = credits + 1;
                 break;

             default:
            	 System.out.println("Sorry, invalid selection");
                 break;
         }
         checkCredits();
     }

     // Method to return change to the user
     public void returnChange()
     {
         int temp = credits;
         credits = 0;
         
         for (int i = 0; i < currencyValues.length; i++)
         {
             int returnAmount = temp / currencyValues[i];
             if (returnAmount > 0)
             {
            	 System.out.println(returnAmount + "X" + currencyValues[i] + "Kr");
             }
             temp = temp % currencyValues[i];
         }
     }

     // Method to check/print users balance
     public void checkCredits()
     {
    	 System.out.println("Your balance is: " + credits + "kr");
     }
     
     // Method to seed products to the vending machine
     public void seed()
     {
         items.add(new Snack(1, "Pringles", "Barbercue flavor", 15, 50));
         items.add(new Snack(2, "Cheeze Doodles", "Hot and spicy", 12, 30));
         items.add(new Snack(3, "Pretzels", "Salty mikes special ones", 10, 80));
         items.add(new Perfume(4, "Boss", "Sand from the bank", 250, 40));
         items.add(new Perfume(5, "Lagerfeld", "Cinamon let me please", 295, 50));
         items.add(new Perfume(6, "Gucci", "Citrus and lavendel", 480, 60));
         items.add(new Perfume(7, "Armani", "Leather me up you naughty", 599, 40));
         items.add(new Drink(8, "Coke", "Tasty as it should be", 8, 33));
         items.add(new Drink(9, "Sprite", "original tase original shit", 8, 33));
         items.add(new Drink(10, "Milk", "3% fat from the bat", 5, 25));
     }


	
}
