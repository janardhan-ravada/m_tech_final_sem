package com.directfromfarm.product.mapper;

import com.directfromfarm.product.entity.Product;
import com.directfromfarm.product.request.ProductRequest;
import com.directfromfarm.product.resource.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    @Autowired
    ProductImageMapper productImageMapper;

    @Autowired
    ProductVariantMapper productVariantMapper;

    public ProductResource toResource(Product product) {
        ProductResource productResource = new ProductResource();

        productResource.setId(product.getId());
        productResource.setName(product.getName());

        product.getImages().forEach(productImage -> productResource.getImages().add(productImageMapper.toResource(productImage)));

        productResource.setProducerId(product.getProducerId());
        product.getProductVariants().forEach(productVariant -> productResource.getVariants().add(productVariantMapper.toResource(productVariant)));

        return productResource;
    }

    public Product toEntity(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setProducerId(productRequest.getProducerId());
        return product;
    }
}
