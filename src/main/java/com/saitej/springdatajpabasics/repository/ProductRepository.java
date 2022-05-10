package com.saitej.springdatajpabasics.repository;

import com.saitej.springdatajpabasics.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findByName(String name);
}
