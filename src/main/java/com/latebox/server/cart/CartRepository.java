package com.latebox.server.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {


//    List<Cart> findByName(String name);

    Cart findById(long id);
}



