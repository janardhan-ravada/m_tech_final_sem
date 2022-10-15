package com.directfromfarm.offer.mappers;

import com.directfromfarm.offer.entity.ProductDiscount;
import com.directfromfarm.offer.request.ProductDiscountRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductDiscountMapper {

    public ProductDiscount toEntity(ProductDiscountRequest productDiscountRequest) {
        ProductDiscount productDiscount = new ProductDiscount();

        productDiscount.setProductId(productDiscountRequest.getProductId());
        productDiscount.setProductVariantId(productDiscountRequest.getProductVariantId());
        productDiscount.setDiscountType(productDiscountRequest.getDiscountType());
        productDiscount.setDiscountAmount(productDiscountRequest.getDiscountAmount());
        productDiscount.setDiscountStartDate(productDiscountRequest.getStartDate());
        productDiscount.setDiscountEndDate(productDiscountRequest.getEndDate());

        return productDiscount;
    }
}
