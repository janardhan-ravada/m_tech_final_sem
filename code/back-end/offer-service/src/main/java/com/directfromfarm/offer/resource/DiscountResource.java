package com.directfromfarm.offer.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResource {

    private String discountType;
    private Double discountAmount;
    private Long offerId;
    private Calendar startDate;
    private Calendar endDate;
}
