package com.naruto.order.controller;

import com.naruto.order.bean.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/service-order")
public class OrderController {


    @GetMapping(path = "/create")
    public Order create() {
        Order order = new Order();
        order.setOrderId(1L);
        return order;
    }
}
