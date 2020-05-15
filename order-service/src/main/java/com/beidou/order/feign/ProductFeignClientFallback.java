package com.beidou.order.feign;

import com.beidou.order.api.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setProductDesc("触发熔断降级");
        return product;
    }
}
