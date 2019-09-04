package com.smddev.springboot.mongo.service;

import com.smddev.springboot.mongo.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    void createProduct(Product product);

    void createProducts(List<Product> products);

    Optional<Product> findProductById(String id);

    Collection<Product> getAllProducts();

    List<String> getAllProductsNames();

    List<String> filterByName(String name);

    List<String> filterByField(String field, String value);

    void updateProduct(Product product);

    void deleteProductById(String id);

    void deleteAllProducts();
}
