package com.saitej.springdatajpabasics.repository;

import com.saitej.springdatajpabasics.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class ProductPagingAndSortingRepositoryTest {

    @Autowired
    private ProductPagingAndSortingRepository sortingRepository;

    @Test
    void testFindAllPaging() {
        Pageable pageable = PageRequest.of(0, 2); //0-> pages , 1->records per page
        Page<Product> products = sortingRepository.findAll(pageable);
        products.forEach(product -> System.out.println(product.getName()));

    }

    @Test
    void testFindAllSorting() {
        sortingRepository
                .findAll(Sort.by("name").descending())
              //  .findAll(Sort.by("name","price").descending())
                .forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void testFindAllPagingAndSorting() {
        Pageable pageable = PageRequest.of(0,2,Sort.by("name").descending());
        sortingRepository.findAll(pageable).forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void testFindAllIdsIn() {
       Pageable pageable= PageRequest.of(1,2);
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);list.add(2L);list.add(3L);list.add(4L);
        List<Product> products = sortingRepository.findByIdIn(list, pageable);
        products.forEach(p-> System.out.println(p.getName()));

    }
}