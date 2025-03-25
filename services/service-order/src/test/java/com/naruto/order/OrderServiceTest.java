package com.naruto.order;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * @Auther: naruto
 * @Email : naruto@163.com
 * @Date: 2025/3/25 09:06
 * @Description: 测试服务发现
 */
@SpringBootTest
public class OrderServiceTest {


    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosDiscoveryClient nacosDiscoveryClient;

    // spring-cloud-discovery服务发现
    @Test
    public void testDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getServiceId() + ":" + instance.getHost() + ":" + instance.getPort());
            }
        }
    }


    // nacos服务发现
    @Test
    public void testNacosDiscoveryClient() {
        List<String> services = nacosDiscoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = nacosDiscoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getServiceId() + ":" + instance.getHost() + ":" + instance.getPort());
            }
        }
    }
}
