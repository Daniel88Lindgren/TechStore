package org.example;

import java.util.List;
import java.util.Scanner;

public class User_cart {

    Scanner scanner = new Scanner(System.in);//Scanner for future user input
    int user_choice = 0;//Declaring variable with 0
    double total_cost = 0;




    public void display_cart(List<String> cart , Products products) {


        System.out.println("Here's all items in your cart: \n");

        if (cart.isEmpty()) {//If Cart has no products
            System.out.println("You have no products in you cart yet");
        } else {

            for (int i = 0; i < cart.size(); i++) {//Loop through items in cart

                String product_name = cart.get(i);
                int index = -1;//To indicate that no match been found. If match is found it updates index

                for (int k = 0; k < products.getProducts().size(); k++) {//Look for similar product in the product class

                    if (products.getProducts().get(k).getName().equals(product_name)) {//If product name is the same, store product index and break loop
                        index = k;
                        break;

                    }
                }


                if (index != -1) {//If match is found update total cost
                    Products.Product product = products.getProducts().get(index);
                    double product_price = product.getPrice();
                    total_cost += product_price;//

                    System.out.println((i + 1) + " : " + product_name + "- Price " + product_price + "Kr");//Display cart items

                }
            }
        }

        System.out.println("\nTotal cost in your shopping cart: " + total_cost + "Kr");//Display the total cost of cart items



        while (user_choice < 1 || user_choice > 3) {//If user input number 1 - 3
            try {//Check is input only is intergers
                System.out.println("Cart menu:\n[1]Purchase items\n[2]Delete items\n[3]Back to menu");
                user_choice = 0;//New/reset value
                user_choice = scanner.nextInt();//Input user

                if (user_choice < 1 || user_choice > 3) {//If user enter outside 1-3
                    System.out.println("\nPlease enter a number from the menu\n");
                }
            }catch (java.util.InputMismatchException e){//If input not interger
                System.out.println("Please only enter numbers");
                scanner.next();
            }
        }

        switch (user_choice) {

            case 1:
                if (!cart.isEmpty()) {//Check cart items

                    for (String product_name : cart) {//Loop cart and find matching indices
                        int index = -1;
                            for(int i = 0; i < products.getProducts().size(); i++){//Look for matching product in product

                                if (products.getProducts().get(i).getName().equals(product_name)){//If product name match, store product index and exit loop.
                                index = i;//To indicate that no match been found. If match is found it updates index
                                break;
                                }
                            }

                        if (index != -1 && products.getProducts().get(index).getStock() > 0) {//Check if product match found and product stock i greater than 0
                            products.minus_product_stock(index);//Method to decrease the stock value on the product.
                        }
                    }

                    System.out.println("\nCongratulations on your purchase!");
                    cart.clear();//Clear cart after accepted purchase
                    total_cost = 0.0;//Clear total cost
                }
                else {
                    System.out.println("Your cart is empty, there is nothing to purchase");//If cart empty
                }
                user_choice = 0;//Clear user choice
                break;//Exit case 1


            case 2:
                    for (String product_name : cart) {//Loop products in the cart
                        for (int i = 0; i < products.getProducts().size();i++) {

                            if (products.getProducts().get(i).getName().equals(product_name)) {//Looking for match in products by name
                                products.add_product_stock(i);//Method to increase product stock
                            }
                        }

                    }

                    System.out.println("\nAll items in your cart has been deleted");
                    cart.clear();
                    total_cost = 0.0;
                    user_choice = 0;
                break;


            case 3:
                total_cost = 0;
                user_choice = 0;
                break;//Exit switch case and return to Main switch

            default:
                System.out.println("\nInvalid choice! Choose a number from the menu please");//If input is anything else byt integer
                user_choice = 0;
                break;


        }


    }


}








