package com.directfromfarm.cart.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private Long consumerId;
    private Long productId;
    private Long productVariantId;
    private Double quantity;
}
