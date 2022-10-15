package com.directfromfarm.product.mapper;

import com.directfromfarm.product.entity.ProductVariant;
import com.directfromfarm.product.request.ProductVariantRequest;
import com.directfromfarm.product.resource.ProductVariantResource;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantMapper {

    public ProductVariantResource toResource(ProductVariant productVariant){
        ProductVariantResource productVariantResource = new ProductVariantResource();

        productVariantResource.setId(productVariant.getId());
        productVariantResource.setDescription(productVariant.getVariantDescription());
        productVariantResource.setTotalQuantity(productVariant.getTotalQuantity());
        productVariantResource.setUnitId(productVariant.getUnitId());
        productVariantResource.setUnitPrice(productVariant.getUnitPrice());
        productVariantResource.setAvailableQuantity(productVariant.getAvailableQuantity());

        return productVariantResource;
    }

    public ProductVariant toEntity(ProductVariantRequest productVariantRequest){
        ProductVariant productVariant = new ProductVariant();

        productVariant.setVariantDescription(productVariantRequest.getDescription());
        productVariant.setUnitPrice(productVariantRequest.getUnitPrice());
        productVariant.setUnitId(productVariantRequest.getUnitId());
        productVariant.setTotalQuantity(productVariantRequest.getTotalQuantity());
        productVariant.setAvailableQuantity(productVariantRequest.getTotalQuantity());

        return productVariant;
    }
}
