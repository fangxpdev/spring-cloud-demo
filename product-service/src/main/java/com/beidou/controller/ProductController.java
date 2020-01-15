package com.beidou.controller;

import com.beidou.entity.Product;
import com.beidou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById( @PathVariable Long id) {

        Product product = productService.findById(id);
        product.setProductDesc(product.getProductDesc() + ":" + port);
        return product;

    }



}
