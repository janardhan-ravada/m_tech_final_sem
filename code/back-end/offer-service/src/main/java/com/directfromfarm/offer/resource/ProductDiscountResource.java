package com.directfromfarm.offer.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDiscountResource {

    private Long productId;
    private Long productVariantId;
    private Double unitPrice;
    private Double unitPriceWithDiscount;
    private Set<DiscountResource> discounts;
}
