package com.saitej.springdatajpabasics.service;

import com.saitej.springdatajpabasics.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Long id,Product product);
    String deleteById(Long id);
    List<Product> findByName(String name); // custom method
    List<Product> findByNameAndDesc(String name,String desc); // custom method
}
