package com.task.productcatalogservice.repo;

import com.task.productcatalogservice.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product, Long> {
    // You can add custom query methods here if needed
    public List<Product> findAll();

    public Product findByproductId(Long productId);

    public Product findByProductName(String name);

    public List<Product> findByProductType(String type);

    public List<Product> findByAvailable(String availability);

//    public List<Product> findByProductPrice(Double minPrice, Double maxPrice);


}
