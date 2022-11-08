package com.maramax.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> selectAllProducts() {
        int count = 28;
        List <Product> products = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            products.add(new Product(i));
        }

        return products;
    }
}
