package com.task.productcatalogservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products")
public class Product {
    @Id
    private long productId;
    private String productName;
    private String productType;
    private String description;
    private int quantity;
    public double productPrice;
    private String available;



}

