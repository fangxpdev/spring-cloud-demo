package com.beidou.service.impl;

import com.beidou.dao.ProductDao;
import com.beidou.entity.Product;
import com.beidou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public Product findById(Long id) {
        Product product = productDao.findById(id).get();
        return product;

    }

    @Override
    public void save(Product product) {
        productDao.saveAndFlush(product);
    }

    @Override
    public void delete(Long id) {

    }
}
