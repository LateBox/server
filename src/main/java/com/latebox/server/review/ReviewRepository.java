package com.latebox.server.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


//    List<Review> findByName(String name);

    Review findById(long id);
}



