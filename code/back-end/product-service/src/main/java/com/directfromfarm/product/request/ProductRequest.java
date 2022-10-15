package com.directfromfarm.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private Long producerId;
    private Set<ProductVariantRequest> variants;
    private Set<String> images;

}
