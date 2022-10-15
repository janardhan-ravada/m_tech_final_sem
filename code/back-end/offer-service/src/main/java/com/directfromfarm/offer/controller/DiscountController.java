package com.directfromfarm.offer.controller;

import com.directfromfarm.offer.request.ProductDiscountRequest;
import com.directfromfarm.offer.resource.ProductDiscountResource;
import com.directfromfarm.offer.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ProductDiscountResource> geProductDiscounts(@RequestParam(value = "product") Long productId, @RequestParam(value = "product_variant") long productVariantId) {
        ProductDiscountResource productDiscountResource = discountService.getProductDiscount(productId, productVariantId);

        return new ResponseEntity<ProductDiscountResource>(productDiscountResource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addDiscountToProduct(@RequestBody ProductDiscountRequest productDiscountRequest) {
        discountService.addProductDiscount(productDiscountRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
