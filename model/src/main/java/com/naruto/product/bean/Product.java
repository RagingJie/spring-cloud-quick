package com.naruto.product.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 231897849023443589L;

    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
