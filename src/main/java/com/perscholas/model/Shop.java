package com.perscholas.model;


import java.util.HashMap;
import java.util.Map;

public class Shop {
    public Map<String, Product> products;
    //What is this object a map
    //How do maps work (key -> value)
    //What did they call it? products



    //private Map<String, Product> products;

    public Shop() {
        products = new HashMap<>();
    }
                                    //product mug
    public void addProduct(Product product) {
        //if products MAP has your product?
        //Then get the product.stock count and increment it
        //else add the product to Products Map object
        //Then set product.stock to 1
        if (products.get(product.getName()) != null) {
            int count = product.getStock();
            count++;
            product.setStock(count);
        }else{
            products.put(product.getName(), product);
            product.setStock(1);
        }

    }

    public int getProductStock(String name) {
        Product product = products.get(name);
        if (product == null) {
            return 0;
        }
        return product.getStock();
    }



}
