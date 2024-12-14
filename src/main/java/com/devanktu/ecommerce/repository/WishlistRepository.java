package com.devanktu.ecommerce.repository;

import com.devanktu.ecommerce.entity.User;
import com.devanktu.ecommerce.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<WishList, Long> {

    List<WishList> findAllByUserId(Long userId);

}
