package com.beidou.order.controller;

import com.beidou.order.api.Product;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Product find() {

        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");

        ServiceInstance instanceInfo = instances.get(0);

        return restTemplate.getForObject("http://" + instanceInfo.getHost() + ":" + instanceInfo.getPort() + "/product/1", Product.class);
    }

}
