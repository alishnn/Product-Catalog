package com.task.productcatalogservice.service;

import com.task.productcatalogservice.model.Product;
import com.task.productcatalogservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
//    private final ProductRepo repository;

    @Autowired
    ProductRepo repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

//    public Product getProductByProductId(Long id) {
//        return repository.findByProductId(id);
//    }

    public Product getByProductId(Long id){
        return repository.findByproductId(id);
    }
    public Product getProductByProductName(String name) {
        return repository.findByProductName(name);
    }

    public List<Product> getProductByProductType(String type) {
        return repository.findByProductType(type);
    }

    public List<Product> getProductByAvailable(String available) {
        return repository.findByAvailable(available);
    }

    public List<Product> getProductByProductPrice(Double minPrice, Double maxPrice ) {
        List<Product> prod = repository.findAll();
        List<Product> price = new ArrayList<>();
        for (Product product : prod
        ) {
            if (product.productPrice <= maxPrice && product.productPrice >= minPrice) {
                price.add(product);


            }

        }
        return price;

    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Product product){
        Product product1 = repository.findByproductId(product.getProductId());
        product1.setProductName(product.getProductName());

        product1.setProductType(product.getProductType());

        product1.setDescription(product.getDescription());

        product1.setQuantity(product.getQuantity());

        product1.setProductPrice(product.getProductPrice());

        product1.setAvailable(product.getAvailable());

        return repository.save(product1);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);

    }


}

