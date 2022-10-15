package com.directfromfarm.offer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest {

    private String name;

    private String description;

    private String couponCode;

    private Calendar startDate;

    private Calendar endDate;

    private Set<ProductDiscountRequest> products = new HashSet<>();

}
