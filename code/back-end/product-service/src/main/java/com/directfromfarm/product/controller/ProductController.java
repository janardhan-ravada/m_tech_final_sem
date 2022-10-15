package com.directfromfarm.product.controller;

import com.directfromfarm.product.request.ProductRequest;
import com.directfromfarm.product.resource.ProductResource;
import com.directfromfarm.product.resource.ProductVariantResource;
import com.directfromfarm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, path = "/{productId}")
    public ProductResource getProduct(@PathVariable(name = "productId") Long productId) {
        return productService.getProduct(productId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ProductVariantResource getProductVariant(@RequestParam(name = "product_variant", required = true) Long productVariantId) {
        return productService.getProductByVariantId(productVariantId);
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        productService.addProduct(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
