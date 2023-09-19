package com.task.productcatalogservice.controller;

import com.task.productcatalogservice.model.Product;
import com.task.productcatalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;




    @GetMapping("/allProducts")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }



//        try {
//            return new ResponseEntity<>(productServ.getProduct(id), HttpStatus.FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

    @GetMapping("/getProductId/{id}")
    public Product getProductId(@PathVariable("id") Long id){
        return productService.getByProductId(id);
    }


    @GetMapping("/productName/{name}")
    public Product getProductByName(@PathVariable("name") String name){
        return productService.getProductByProductName(name);
    }

    @GetMapping("/productType/{type}")
    public List<Product> getProductByType(@PathVariable("type") String type){
        return productService.getProductByProductType(type);
    }


    @GetMapping("/productPrice/{minPrice}/{maxPrice}")
    public List<Product> getProductByPrice(@PathVariable("minPrice") Double minPrice, @PathVariable("maxPrice") Double maxPrice){
        return productService.getProductByProductPrice(minPrice, maxPrice);
    }

    @GetMapping("/productAvail/{available}")
    public List<Product> checkProductAvailability(@PathVariable("available") String available){
        return productService.getProductByAvailable(available);
    }



    @PostMapping("/addProducts")

    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/allProducts/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){


        try

    {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }
        catch(Exception e )

    {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}



    @DeleteMapping("/allProducts/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id)
    {
        try
        {
            productService.deleteProduct(id);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id+" was deleted",HttpStatus.OK);
    }

}
