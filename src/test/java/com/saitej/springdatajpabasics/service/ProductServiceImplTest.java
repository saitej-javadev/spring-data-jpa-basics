package com.saitej.springdatajpabasics.service;

import com.saitej.springdatajpabasics.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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
                        .name("Iphone 11Pro")
                        .desc("from Apple Inc")
                        .price(1400.0)
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


    @Test
    void findByNameAndDesc() {
        List<Product> products = productService.findByNameAndDesc("S20", "from Samsung Inc");
        log.info("Logging products by findByNameAndDesc() {}", products);

    }

    @Test
    void findByPriceGreaterThan() {
        List<Product> products = productService.findByPriceGreaterThan(800.0);
        log.info("Logging products by findByPriceGreaterThan() {}", products);

    }

    @Test
    void findByDescContains() {
        List<Product> products = productService.findByDescContains("Sony");
       // log.info("Logging products by findByDescContains() {}", products);
        products.forEach(product -> System.out.println(product.getName()));

    }


    @Test
    void findByPriceBetween() {
        List<Product> products = productService.findByPriceBetween(800,1200);
        //refer for below impl:https://stackoverflow.com/questions/34500842/how-to-use-foreach-with-slf4j-logger-info
        products.forEach(product -> log.info("Logging products by findByPriceBetween() {}",product.getName()));
    }

    @Test
    void findByDescLike() {
        List<Product> products = productService.findByDescLike("Apple");
        log.info("Logging products by findByDescLike() {}", products);
    }

    @Test
    void findByIdsIn() {
        ArrayList list = new ArrayList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        List products = productService.findByIdIn(list);
        log.info("Logging products by findByIdsIn() {}", products);
    }

}
