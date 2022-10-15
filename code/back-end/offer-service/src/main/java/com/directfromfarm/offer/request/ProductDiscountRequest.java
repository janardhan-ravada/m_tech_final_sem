package com.directfromfarm.offer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDiscountRequest {
    private Long productId;
    private Long productVariantId;
    private String discountType;
    private Double discountAmount;
    private Calendar startDate;
    private Calendar endDate;

}
