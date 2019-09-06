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
    public void create(Product product) {
        dao.save(product);
    }

    @Override
    public Optional<Product> get(String id) {
        return dao.findById(id);
    }

    @Override
    public Collection<Product> getAll() {
        return dao.findAll();
    }

    @Override
    public List<String> getAllNames() {
        return productsToStrings(dao.findAll());
    }

    @Override
    public List<String> filterByField(String field, String value) {
        return getProductNames(getAll(), field, value);
    }

    @Override
    public void update(Product product) {
        dao.save(product);
    }

    @Override
    public void delete(String id) {
        dao.deleteById(id);
    }

    private List<String> productsToStrings(List<Product> products) {
        return products.stream().map(Product::getName).collect(Collectors.toList());
    }

    private List<String> getProductNames(Collection<Product> products, String field, String value) {
        if (field.isEmpty()) {
            return Collections.emptyList();
        }
        if (field.equals("name")) {
            return productsToStrings(dao.findProductsByName(value));
        }
        List<String> productsNamesList = new ArrayList<>();
        Map<String, String> params;
        for (Product product : products) {
            params = new HashMap<>(product.getParameters());
            String curValue = params.get(field);
            if ((curValue != null) && (curValue.toLowerCase().contains(value.toLowerCase()))) {
                productsNamesList.add(product.getName());
            }
        }
        return productsNamesList.isEmpty() ? Collections.emptyList() : productsNamesList;
    }
}
