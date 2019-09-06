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
    private static final String REST_URL = "/api/product";

    @Autowired
    ProductService service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        logger.debug("Creating new product");
        service.create(product);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(product);
    }

    @GetMapping(value = "/getall")
    public List<String> getAll() {
        logger.debug("Getting all products names");
        return service.getAllNames();
    }

    @GetMapping(value = "/{product-id}")
    public Optional<Product> getById(@PathVariable(value = "product-id") String id) {
        logger.debug("Getting product by id = {}", id);
        return service.get(id);
    }

    @GetMapping(value = "/filter")
    public List<String> filterByField(
            @RequestParam() String field,
            @RequestParam() String value) {
        logger.debug("Getting product by field = {} with value = {}", field, value);
        return service.filterByField(field, value);
    }

    @PutMapping(value = "/{product-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@PathVariable(value = "product-id") String id, @RequestBody Product product) {
        logger.debug("Updating product with id = {}", id);
        product.setId(id);
        service.update(product);
    }

    @DeleteMapping(value = "/{product-id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(value = "product-id") String id) {
        logger.debug("Deleting product with id = {}", id);
        service.delete(id);
    }
}
