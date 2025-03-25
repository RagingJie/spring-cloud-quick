package com.naruto.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "order")
public class OrderProperties {

    // 订单超时时间
    private String timeout;
    // 订单自动确认收货时间
    private String autoConfirm;
    // api接口地址
    private String apiUrl;

}
