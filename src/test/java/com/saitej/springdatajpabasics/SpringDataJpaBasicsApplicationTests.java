package com.saitej.springdatajpabasics;

import com.saitej.springdatajpabasics.entities.Product;
import com.saitej.springdatajpabasics.repository.ProductRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class SpringDataJpaBasicsApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
// To enable Level - 1 caching
    void testGetProductCaching() {

        /*Level - 1 Caching*/

        //   productRepository.findById(3L);
        //    productRepository.findById(3L);//without @Transactional every time query will be executed //Hibernate: select product0_.id as id1_0_0_, product0_.description as descript2_0_0_, product0_.name as name3_0_0_, product0_.price as price4_0_0_ from products product0_ where product0_.id=?


        /*To Evict Object from Cache*/

        Session session = entityManager.unwrap(Session.class);
        Product product = productRepository.findById(3L).orElse(null);
        session.evict(product);// It will remove object from the cache and query will executed twice again
        productRepository.findById(3L);


        /*2nd Level Caching*/
       /* In Second level caching even after evicting the object query will be executed only once becuz of 2nd level caching
                to enable 2nd level caching uncomment @Cache on Product entity*/
    }
}
