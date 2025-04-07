package com.naruto.order.controller;

import com.naruto.order.bean.Order;
import com.naruto.order.properties.CommonProperties;
import com.naruto.order.properties.OrderProperties;
import com.naruto.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope  // 配置刷新
@RestController
@Slf4j
@RequestMapping(path = "/service-order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProperties orderProperties;

    @Autowired
    private CommonProperties commonProperties;

    @Value("${order.timeout}")
    private String timeout;

    @Value("${order.auto-confirm}")
    private String autoConfirm;

    @Value("${order.api-url}")
    private String apiUrl;

    @GetMapping(path = "/create")
    public Order create(@RequestParam("userId") Long userId,
                        @RequestParam("productId") Long productId) {
        return orderService.create(userId, productId);
    }


    @GetMapping(path = "/getConfigOne")
    public String getConfigOne() {
        return "timeout:" + this.timeout + ";  autoConfirm:" + this.autoConfirm + ";  apiUrl：<a>" + this.apiUrl + "</a>";
    }

    @GetMapping(path = "/getConfigTwo")
    public String getConfigTwo() {
        return "timeout:" + orderProperties.getTimeout() + "\n"
                + "autoConfirm:" + orderProperties.getAutoConfirm() + "\n"
                + "apiUrl:" + orderProperties.getApiUrl() + "\n"
                + "version:" + orderProperties.getVersion();
    }

    @GetMapping(path = "/getConfigThree")
    public String getConfigThree() {
        return "common-name:" + commonProperties.getName();
    }
}
