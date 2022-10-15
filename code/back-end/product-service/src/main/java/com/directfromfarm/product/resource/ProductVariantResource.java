package com.directfromfarm.product.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantResource {

    private Long id;
    private String description;
    private Long unitId;
    private Double unitPrice;
    private Double totalQuantity;
    private Double availableQuantity;
}
