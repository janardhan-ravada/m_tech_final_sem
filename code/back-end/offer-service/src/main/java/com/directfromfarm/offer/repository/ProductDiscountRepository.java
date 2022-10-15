package com.directfromfarm.offer.repository;

import com.directfromfarm.offer.entity.ProductDiscount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductDiscountRepository extends CrudRepository<ProductDiscount, Long> {

    Set<ProductDiscount> findByProductIdAndProductVariantId(Long productId, Long productVariantId);

}
