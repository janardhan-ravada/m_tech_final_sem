package com.directfromfarm.product.mapper;

import com.directfromfarm.product.entity.ProductImage;
import com.directfromfarm.product.resource.ProductImageResource;
import org.springframework.stereotype.Service;

@Service
public class ProductImageMapper {

    public ProductImageResource toResource(ProductImage productImage){
        ProductImageResource imageResource = new ProductImageResource();

        imageResource.setId(productImage.getId());
        imageResource.setImageURL(productImage.getImageURL());

        return imageResource;
    }
}
