package com.naruto.product.service.impl;

import com.naruto.product.bean.Product;
import com.naruto.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("13999"));
        product.setProductName("拯救者Y9000P");
        product.setNum(2);
        return product;
    }
}
