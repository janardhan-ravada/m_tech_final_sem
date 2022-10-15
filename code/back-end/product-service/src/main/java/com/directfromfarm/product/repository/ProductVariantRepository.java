package com.directfromfarm.product.repository;

import com.directfromfarm.product.entity.ProductVariant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantRepository extends CrudRepository<ProductVariant, Long> {
}
