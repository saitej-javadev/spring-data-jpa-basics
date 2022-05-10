package com.saitej.springdatajpabasics.service;

import com.saitej.springdatajpabasics.entities.Product;
import com.saitej.springdatajpabasics.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    ProductService productService;

    @Test
    void getProducts() {
        List<Product> products = productService.getProducts();
        log.info("logging products: {}", products);

    }

    @Test
    void getProductById() {
        Product product = productService.getProductById(2L);
        log.info("Logging product: {}", product);
    }

    @Test
    void saveProduct() {
        Product savedProduct = productService.saveProduct(
                new Product()
                        .builder()
                        .name("Realme")
                        .desc("from Realme Inc")
                        .price(400.0)
                        .build());
        log.info("Logging saved Product:{} ", savedProduct);
    }

    @Test
    void updateProduct() {
        Product retrievedProduct = productService.getProductById(5L);
        Product product = new Product();
        Product build = product.builder().id(5L).name("MI").desc("from MI inc").price(retrievedProduct.getPrice()).build();
        Product updatedProduct = productService.saveProduct(build);
        log.info("Logging updated Product: {} ", updatedProduct);
    }

    @Test
    void deleteById() {
        String s = productService.deleteById(5L);
        log.info("Logging deleted Product {}", s);
    }

    @Test
    void findByName() {
        List<Product> product = productService.findByName("Iphone");
        log.info("Logging products by findByName() {}", product);

    }
}
