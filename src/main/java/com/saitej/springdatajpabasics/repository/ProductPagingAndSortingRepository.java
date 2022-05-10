package com.saitej.springdatajpabasics.repository;

import com.saitej.springdatajpabasics.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductPagingAndSortingRepository extends PagingAndSortingRepository<Product,Long> {

    List<Product> findByIdIn(List<Long> ids, Pageable pageable); // custom method
}
