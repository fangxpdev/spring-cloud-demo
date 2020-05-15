package com.beidou.controller;

import com.beidou.entity.Product;
import com.beidou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {

        Product product = productService.findById(id);
        product.setProductDesc(product.getProductDesc() + ":" + port);
        return product;

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "success";
    }
}
