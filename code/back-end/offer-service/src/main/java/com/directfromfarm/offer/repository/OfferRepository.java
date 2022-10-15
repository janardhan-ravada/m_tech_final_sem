package com.directfromfarm.offer.repository;

import com.directfromfarm.offer.entity.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
}
