package com.perscholas.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopTest {

    //private Shop shop;
    public Shop shop;
    @BeforeEach
    public void setUp() {
        shop = new Shop();
    }

    @AfterEach
    public void tearDown() {
        shop.products.clear(); // Reset shop's stock to zero after each test
    }

    @Test
    public void testAddProduct() {
        String productName = "T-Shirt";
        double price = 19.99;
        int initialStock = 0;
        int expectedStock = 1;

        Product product = new Product(productName, price, initialStock);
        shop.addProduct(product);

        int actualStock = shop.getProductStock(productName);

        assertEquals(expectedStock, actualStock);
    }

    @Test
    public void testAddDuplicateProduct() {
        //Create a product instance of a Mug
        String productName = "Mug";
        double price = 9.99;

        //Products belong to a shop
        //Currently this mug does not belong to a shop and as an initial stock of 0

        //Test information
        //We start with an initial stock of 0 then add the Mug twice and end with a stock of 2
        //Think of stock really as Quantity! it is a weird word choice
        int initialStock = 0;
        int expectedStock = 2;

        // Below line creates => Product [name: mug , price: 9.99, initialstock 0]
        Product product = new Product(productName, price, initialStock);


        //If we add the same product to the same shop 2x
        //We expect the quantity or initialStock -> 2
        shop.addProduct(product); //-> initial stock 1
        shop.addProduct(product); //-> initial stock 2

        int actualStock = shop.getProductStock(productName); // -> this should be 2
        //How do we modify getProductStock to return the value 2?

        assertEquals(expectedStock, actualStock);
    }

    @Test
    public void testGetProductStock() {
        String productName = "Hat";
        double price = 14.99;
        int initialStock = 5;

        Product product = new Product(productName, price, initialStock);
        shop.addProduct(product);

        int expectedStock = initialStock;
        int actualStock = shop.getProductStock(productName);

        assertEquals(expectedStock, actualStock);
    }

    @Test
    public void testAddProductWithNegativePrice() {
        String productName = "Water Bottle";
        double price = -5.00; // Negative price
        int initialStock = 10;

        assertThrows(IllegalArgumentException.class, () -> shop.addProduct(new Product(productName, price, initialStock)));
    }

    @Test
    public void testAddProductWithNegativeStock() {
        String productName = "Notebook";
        double price = 7.99;
        int initialStock = -20; // Negative stock

        assertThrows(IllegalArgumentException.class, () -> shop.addProduct(new Product(productName, price, initialStock)));
    }

}
