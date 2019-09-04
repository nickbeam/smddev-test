package com.smddev.springboot.mongo.controller;

import com.smddev.springboot.mongo.model.Product;
import com.smddev.springboot.mongo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    private static final String REST_URL = "/api/product/get";

    @Autowired
    ProductService service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        logger.debug("Creating new product");
        service.createProduct(product);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(product);
    }

    @PostMapping(value = "/createall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAll(@RequestBody List<Product> products) {
        logger.debug("Creating new products");
        service.createProducts(products);
    }

    @GetMapping(value = "/getall")
    public Collection<Product> getAll() {
        logger.debug("Getting all products");
        return service.getAllProducts();
    }

    @GetMapping(value = "/getallnames")
    public List<String> getAllNames() {
        logger.debug("Getting all products names");
        return service.getAllProductsNames();
    }

    @GetMapping(value = "/get/{product-id}")
    public Optional<Product> getById(@PathVariable(value = "product-id") String id) {
        logger.debug("Getting product by id = {}", id);
        return service.findProductById(id);
    }

    @GetMapping(value = "/getbyname/{product-name}")
    public List<String> getByName(@PathVariable(value = "product-name") String name) {
        logger.debug("Getting product by name = {}", name);
        return service.filterByName(name);
    }

    @GetMapping(value = "/filter")
    public List<String> filterByField(
            @RequestParam() String field,
            @RequestParam() String value) {
        logger.debug("Getting product by field = {} with value = {}", field, value);
        return service.filterByField(field, value);
    }

    @PutMapping(value = "/update/{product-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@PathVariable(value = "product-id") String id, @RequestBody Product product) {
        logger.debug("Updating product with id = {}", id);
        product.setId(id);
        service.updateProduct(product);
    }

    @DeleteMapping(value = "/delete/{product-id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(value = "product-id") String id) {
        logger.debug("Deleting product with id = {}", id);
        service.deleteProductById(id);
    }

    @DeleteMapping(value = "/deleteall")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAll() {
        logger.debug("Deleted all products");
        service.deleteAllProducts();
    }
}
