package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Products {

    private final ArrayList<Product> products = new ArrayList<>();//All products
    private final List<String> cart = new ArrayList<>();//Products in cart
    public List<Product> getProducts() {
        return products;
    }//Get list of products stored in Products



    public static class Product {
        private final String name;
        private final double price;
        private int stock;

        public Product(String name, double price, int stock) {//Constructor for Product
            this.name = name;
            this.price = price;
            this.stock = stock;
        }


        public String getName() {
            return name;
        }//Get name of product and return name

        public double getPrice(){
            return price;
        }// Get price of product and return price

        public int getStock(){
            return stock;
        }//Get stock of product and return stock

        public void setStock(int stock){
            this.stock = stock;
        }//Give stock new value
    }


    public List<String> getCart () {//Gets uses cart with added products
        return cart;
    }


    public void minus_product_stock(int index){//Method to decrease stock value
        Product product = products.get(index);
        if (product.getStock() > 0){
            product.setStock(product.getStock() - 1);
        }
    }


    public void add_product_stock(int index){//Method the increase stock value
        Product product = products.get(index);
        product.setStock(product.getStock() +1);
    }


    public Products() {//Adding value to each product.

        products.add(new Product("Apple MacBook Pro", 79_999.99, 1));
        products.add(new Product("Samsung Galaxy S62", 12_999.0, 1));
        products.add(new Product("JBL SoundMaster", 2599.0, 1));
        products.add(new Product("Bang Olufsen TV", 55_000.0, 1));
        products.add(new Product("Apple Smart Watch 2", 3100, 1));
        products.add(new Product("LG Projector", 6999.99, 1));
        products.add(new Product("Sony 200\" TV", 120_000.0, 0));
    }


    public void View_products_and_add() {//Method used in Main from User. Here will display all products and a menu for different choices.


        boolean back_to_menu;//Return to menu varible
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < products.size(); i++) {//Product loop to display all products and their values.
            Product product = products.get(i);

            System.out.println("Product code: " + (i) + " " + product.getName() + " - Price:   "
                               + product.getPrice() + " Kr - In stock: " + product.getStock() );
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }


        do {
            back_to_menu = false;//Gives boolean value false
            System.out.println("|-------------------------|");
            System.out.println("| Product menu:           |\n| [1]Add product to cart  |\n| [2]Return to menu       |");
            System.out.println("|-------------------------|");


            int user_choice = scanner.nextInt();//User input stored in variable user_choice as an integer.

            if (user_choice == 1) {//User enter 1
                System.out.println("Please enter product code to add products to your cart: ");

                try {//This will check user input so it's only interger

                    int user_add_cart = scanner.nextInt();//User input

                    if (user_add_cart >= 0 && user_add_cart < products.size()) {//Check if input is in product code range
                        Product product = products.get(user_add_cart);

                        if (product.getStock() > 0) {//Check if product stock is greater than 0
                            minus_product_stock(user_add_cart);//Method decrease product stock
                            cart.add(product.getName());//Product name added to users cart

                            System.out.println("Product added to your cart!\n");
                        }
                        else {
                            System.out.println("Sorry, the product is out of stock.");//Product stock is less than 1
                        }

                    }
                    else {
                        System.out.println("Invalid product code. Please enter a correct number\n");//Input is out of code range
                    }

                }
                catch (InputMismatchException e){//User input anything else but integer
                    System.out.println(" Please enter a number from the menu");
                    scanner.next();
                }

            }
            else if (user_choice == 2) {//User input 2
                back_to_menu = true;//Boolean true, back to Main

            }
            else {//User input anything else but integer
                System.out.println("Invalid choice! Please enter a number from the menu");
            }


        }
        while (! back_to_menu);//Keeps the loop running until false

    }



}


