package com.beidou.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.beidou.order.api.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class SentinelOrderController {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * ribbon
     *
     * @return
     */
    @SentinelResource(blockHandler = "orderBlockHandler", fallback = "orderFallBack")
    @RequestMapping(value = "/ribbon", method = RequestMethod.GET)
    public Product ribbon() {

        return restTemplate.getForObject("http://product-service/product/1", Product.class);
    }


    public Product orderBlockHandler() {
        Product product = new Product();
        product.setProductDesc("触发熔断降级方法");
        return product;
    }

    public Product orderFallBack() {
        Product product = new Product();
        product.setProductDesc("抛出异常降级方法");
        return product;
    }

}
