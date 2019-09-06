package com.smddev.springboot.mongo.service;

import com.smddev.springboot.mongo.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    void create(Product product);

    void createProducts(List<Product> products);

    Optional<Product> get(String id);

    Collection<Product> getAll();

    List<String> getAllNames();

    List<String> filterByName(String name);

    List<String> filterByField(String field, String value);

    void update(Product product);

    void delete(String id);
}
