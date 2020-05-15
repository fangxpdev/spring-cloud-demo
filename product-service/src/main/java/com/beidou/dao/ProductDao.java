package com.beidou.dao;

import com.beidou.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductDao extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {


}
