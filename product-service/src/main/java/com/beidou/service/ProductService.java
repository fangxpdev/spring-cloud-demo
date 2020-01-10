package com.beidou.service;

import com.beidou.entity.Product;

public interface ProductService {

    Product findById(Long id);

    void save(Product product);

    void delete(Long id);

}
