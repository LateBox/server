package com.latebox.server.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

// to understand why next line is commented take a look at this: https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
//public interface ProductRepository extends CrudRepository<Product, Long> {
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByName(String name);

    Product findById(long id);
}



