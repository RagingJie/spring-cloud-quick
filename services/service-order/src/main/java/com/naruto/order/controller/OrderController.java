package com.naruto.order.controller;

import com.naruto.order.bean.Order;
import com.naruto.order.properties.OrderProperties;
import com.naruto.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/service-order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProperties orderProperties;

    @GetMapping(path = "/create")
    public Order create(@RequestParam("userId") Long userId,
                        @RequestParam("productId") Long productId) {
        return orderService.create(userId, productId);
    }


    @GetMapping(path = "/getConfig")
    public String getConfig() {
        return "timeout:" + orderProperties.getTimeout() + ";  autoConfirm:" + orderProperties.getAutoConfirm() + ";  apiUrl:<a>" + orderProperties.getApiUrl() + "</a>";
    }
}
