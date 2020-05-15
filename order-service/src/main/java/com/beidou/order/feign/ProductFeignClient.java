package com.beidou.order.feign;

import com.beidou.order.api.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "product-service", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    Product findById(@PathVariable Long id);


}
