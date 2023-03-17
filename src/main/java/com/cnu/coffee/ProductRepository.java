package com.cnu.coffee;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {

    Map<Long, Product> db = new HashMap<>();


    public String insert(Product product) {
        db.put(product.getId(), product);

        return db.get(product.getId()).getName();
    }
}
