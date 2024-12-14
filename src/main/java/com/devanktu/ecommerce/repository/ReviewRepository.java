package com.devanktu.ecommerce.repository;

import com.devanktu.ecommerce.entity.FAQ;
import com.devanktu.ecommerce.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProductId(Long productsId);

}
