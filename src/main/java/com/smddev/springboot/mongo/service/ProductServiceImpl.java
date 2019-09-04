package com.smddev.springboot.mongo.service;

import com.smddev.springboot.mongo.dao.ProductDao;
import com.smddev.springboot.mongo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao dao;

    @Override
    public void createProduct(Product product) {
        dao.save(product);
    }

    @Override
    public void createProducts(List<Product> products) {
        dao.saveAll(products);
    }

    @Override
    public Optional<Product> findProductById(String id) {
        return dao.findById(id);
    }

    @Override
    public Collection<Product> getAllProducts() {
        return dao.findAll();
    }

    @Override
    public List<String> getAllProductsNames() {
        return productsToStrings(dao.findAll());
    }

    @Override
    public List<String> filterByName(String name) {
        return productsToStrings(dao.findProductsByName(name));
    }

    @Override
    public List<String> filterByField(String field, String value) {
        return getProductNames(getAllProducts(), field, value);
    }

    @Override
    public void updateProduct(Product product) {
        dao.save(product);
    }

    @Override
    public void deleteProductById(String id) {
        dao.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        dao.deleteAll();
    }

    private List<String> productsToStrings(List<Product> products) {
        return products.stream().map(Product::getName).collect(Collectors.toList());
    }

    private List<String> getProductNames(Collection<Product> products, String field, String value) {
        if (field.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> productsNamesList = new ArrayList<>();
        Map<String, String> params;
        for (Product product : products) {
            params = new HashMap<>(product.getParameters());
            String curValue = params.get(field);
            if ((curValue != null) && (curValue.equalsIgnoreCase(value))) {
                productsNamesList.add(product.getName());
            }
        }
        return productsNamesList.isEmpty() ? Collections.emptyList() : productsNamesList;
    }
}
