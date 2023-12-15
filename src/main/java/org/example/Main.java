package org.example;

import java.util.List;
import java.util.Scanner;






public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);//Scanner for user input
        Products products = new Products();//Instance of the Product class to manage products and shopping cart
        User_cart user_cart1 = new User_cart();//Instance of User_cart class to handle user shopping cart


        System.out.println("<><><><><>Welcome to the Tech Store<><><><><>");

        while (true) {//Loop meny until system exit, number 3.
            System.out.println("|-----------------|");
            System.out.println("| [1]Products     |\n| [2]User cart    |\n| [3]Quit         |");
            System.out.println("|-----------------|");


              String user_choice = scanner.next();//User input

              switch (user_choice) {
                case "1"://If to return value of method
                    products.View_products_and_add();
                    break;//Ends Case 1

                case "2":
                    List<String> cart = products.getCart();//Get users shopping cart from products
                    user_cart1.display_cart(cart, products);//Displays the items in the cart
                    break;

                case "3":
                    System.out.println("<><><><><>Thank you for visiting the Tech Store! See you later<><><><><>");
                    System.exit(0);//End program with 'status 0'. No break needed


                default:
                    System.out.println("Please enter a number from the menu!");

              }

            }

        }

    }

