package com.directfromfarm.offer.restobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResource implements Serializable {
    private Long id;
    private String name;
    private Long producerId;
    private Set<ProductVariantResource> variants = new HashSet<>();
}
