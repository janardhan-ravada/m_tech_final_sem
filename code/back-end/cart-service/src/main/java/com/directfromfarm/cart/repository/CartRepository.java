package com.directfromfarm.cart.repository;

import com.directfromfarm.cart.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    Set<Cart> findByConsumerId(Long consumerId);
}
