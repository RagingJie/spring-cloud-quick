package com.naruto.order.service.impl;

import com.naruto.order.bean.Order;
import com.naruto.order.service.OrderService;
import com.naruto.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Order create(Long userId, Long productId) {
        Product product = getProductByIdOne(productId);
        Order order = new Order();
        order.setId(20250325001L);
        order.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(product.getNum())).setScale(2, BigDecimal.ROUND_HALF_UP));
        order.setUserId(userId);
        order.setNickName("《拯救者》");
        order.setAddress("广东深圳福田区001街道008号");
        order.setProductList(Arrays.asList(product));
        return order;
    }


    // 远程调用，获取商品信息，第一版
    private Product getProductByIdOne(Long productId) {
        // 使用服务发现的方式获取服务列表 ip:port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        // 获取第一个服务实例
        ServiceInstance serviceInstance = instances.get(0);
        // 拼接请求地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/service-product/getProduct/" + productId;
        return restTemplate.getForObject(url, Product.class);
    }


    // 进阶1：实现负载均衡远程调用，第二版
    private Product getProductByIdTwo(Long productId) {
        // 使用负载均衡的方式获取服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-product");
        // 拼接请求地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/service-product/getProduct/" + productId;
        return restTemplate.getForObject(url, Product.class);
    }
}
