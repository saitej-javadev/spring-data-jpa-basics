package com.saitej.springdatajpabasics.repository;

import com.saitej.springdatajpabasics.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name, String desc);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByDescContains(String name);

    List<Product> findByPriceBetween(double price, double price2);

    List<Product> findByDescLike(String name);

    List<Product> findByIdIn(List<Long> ids);
}
