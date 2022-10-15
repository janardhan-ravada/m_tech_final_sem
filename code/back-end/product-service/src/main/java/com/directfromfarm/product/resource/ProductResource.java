package com.directfromfarm.product.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResource {
    private Long id;
    private String name;
    private Long producerId;
    private Set<ProductVariantResource> variants = new HashSet<>();
    private Set<ProductImageResource> images = new HashSet<>();

}
