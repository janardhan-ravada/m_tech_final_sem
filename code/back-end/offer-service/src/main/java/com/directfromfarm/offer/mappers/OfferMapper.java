package com.directfromfarm.offer.mappers;

import com.directfromfarm.offer.entity.Offer;
import com.directfromfarm.offer.request.OfferRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class OfferMapper {

    public Offer toEntity(OfferRequest offerRequest){
        Offer offer = new Offer();

        offer.setName(offerRequest.getName());
        offer.setDescription(offerRequest.getDescription());
        offer.setCouponCode(offerRequest.getCouponCode());
        offer.setStartDate(offerRequest.getStartDate());
        offer.setEndDate(offerRequest.getEndDate());
        offer.setCreatedDate(Calendar.getInstance());
        offer.setUpdatedDate(Calendar.getInstance());

        return offer;
    }
}
