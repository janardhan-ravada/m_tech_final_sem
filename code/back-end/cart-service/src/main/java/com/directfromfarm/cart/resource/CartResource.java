package com.directfromfarm.cart.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResource {
    private Long productId;
    private Long productVariantId;
    private Long cartId;
    private Double quantity;
    private Double unitPrice;
    private Double unitPriceWithDiscount;
    private Set<DiscountResource> discounts = new HashSet<>();
}
