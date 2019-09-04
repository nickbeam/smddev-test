package com.smddev.springboot.mongo.dao;

import com.smddev.springboot.mongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends MongoRepository<Product, Object> {
    @Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
    List<Product> findProductsByName(String name);

    @Query("{ 'parameters' : { $elemMatch : { ?0 : ?1 } } }")
    List<Product> findByField(String filed, String value);
}
