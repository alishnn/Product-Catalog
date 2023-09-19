package com.task.productcatalogservice;


import static org.hamcrest.CoreMatchers.notNullValue;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.util.ArrayList;

import java.util.List;


import com.task.productcatalogservice.controller.ProductController;
import com.task.productcatalogservice.model.Product;
import com.task.productcatalogservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;





@WebMvcTest(value = ProductController.class)

class ProductControllerTest {


    @Autowired

    MockMvc mockMvc;


    @MockBean

    ProductService productService;


    Product product = new Product(12, "damsung", "mobile", "best deal", 1, 2000, "yes");

    List<Product> list = new ArrayList<>();


    @BeforeEach
    void beforeEach() {

        list.add(product);

    }


    @Test
    void testGetAllProducts() throws Exception {

        when(productService.getAllProducts()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/allProducts")).andExpect(jsonPath("$", notNullValue()));

    }


    @Test
    void testGetProductById() throws Exception {

        when(productService.getByProductId(12L)).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/getProductId/" + product.getProductId())).andExpect(status().isOk());


    }




    @Test

    void testGetProductByProductType() throws Exception {

        when(productService.getProductByProductType("mobile")).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/productType/{type}", "mobile" )).andExpect(status().isOk());

    }



//    @Test
//
//    void testGetProductByName() throws Exception {
//
//        when(productService.getProductByProductName("damsung")).thenReturn(product);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/allProducts/{name}"+product.getProductName())).andExpect(status().isOk());
//
//    }

    @Test
    void testGetProductByName() throws Exception {
        when(productService.getProductByProductName("damsung")).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/productName/{name}", "damsung"))
                .andExpect(status().isOk());
    }




//	@Test
//
//	void testGetProductByPrice() throws Exception {
//
//		when(productService.getProductByProductPrice(100D,10000D)).thenReturn(list);
//
//
//
//		mockMvc.perform(MockMvcRequestBuilders.get("/allProducts/{minPrice}/{maxPrice}"+product.getProductPrice())).andExpect(status().isOk());
//
//	}


    @Test
    void testGetProductByPrice() throws Exception {
        when(productService.getProductByProductPrice(100D, 10000D)).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/productPrice/{minPrice}/{maxPrice}", 100D, 10000D))
                .andExpect(status().isOk());
    }









    @Test

    void testGetProductByAvailable() throws Exception {

        when(productService.getProductByAvailable("yes")).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/productAvail/{available}", "yes")).andExpect(status().isOk());

    }

//

//	@Test

//	void testAddProduct() {

//		fail("Not yet implemented");

//	}

//

//	@Test

//	void testUpdateProduct() {

//		fail("Not yet implemented");

//	}

//





}

