package com.directfromfarm.product.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductImageResource {
    private Long id;
    private String imageURL;
}
