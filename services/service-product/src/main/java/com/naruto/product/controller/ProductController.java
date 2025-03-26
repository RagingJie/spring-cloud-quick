package com.naruto.product.controller;

import com.naruto.product.bean.Product;
import com.naruto.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(path = "service-product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/getProduct/{id}")
    public Product getProduct(@PathVariable("id") Long productId) {
       return productService.getProductById(productId);
    }
}
