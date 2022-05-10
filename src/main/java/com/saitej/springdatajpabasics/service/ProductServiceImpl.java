package com.saitej.springdatajpabasics.service;

import com.saitej.springdatajpabasics.entities.Product;
import com.saitej.springdatajpabasics.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteById(Long id) {
        productRepository.deleteById(id);
        return "Product deleted : " + id;

    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByNameAndDesc(String name, String desc) {
        return productRepository.findByNameAndDesc(name, desc);
    }

    @Override
    public List<Product> findByPriceGreaterThan(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findByDescContains(String name) {
        return productRepository.findByDescContains(name);
    }

    @Override
    public List<Product> findByPriceBetween(double price, double price2) {
        return productRepository.findByPriceBetween( price,  price2);
    }

    @Override
    public List<Product> findByDescLike(String name) {
        return productRepository.findByDescLike("Apple");
    }

    @Override
    public List<Product> findByIdIn(List<Long> ids) {
        return productRepository.findByIdIn(ids);
    }
}
