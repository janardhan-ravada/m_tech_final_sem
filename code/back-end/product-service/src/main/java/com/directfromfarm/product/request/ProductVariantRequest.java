package com.directfromfarm.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantRequest {
    private String description;
    private Long unitId;
    private Double unitPrice;
    private Double totalQuantity;
    private String discountType;
    private Double discount;
    private Calendar startDate;
    private Calendar endDate;
}
