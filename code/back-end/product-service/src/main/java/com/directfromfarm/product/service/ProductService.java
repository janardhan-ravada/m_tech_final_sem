package com.directfromfarm.product.service;

import com.directfromfarm.product.entity.Product;
import com.directfromfarm.product.entity.ProductImage;
import com.directfromfarm.product.entity.ProductVariant;
import com.directfromfarm.product.exception.ResourceNotFoundException;
import com.directfromfarm.product.mapper.ProductMapper;
import com.directfromfarm.product.mapper.ProductVariantMapper;
import com.directfromfarm.product.repository.ProductImageRepository;
import com.directfromfarm.product.repository.ProductRepository;
import com.directfromfarm.product.repository.ProductVariantRepository;
import com.directfromfarm.product.request.ProductRequest;
import com.directfromfarm.product.resource.ProductResource;
import com.directfromfarm.product.resource.ProductVariantResource;
import com.directfromfarm.product.restobj.ProductDiscountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductVariantMapper productVariantMapper;

    @Autowired
    private RestTemplate restTemplate;

    public void addProduct(ProductRequest productRequest) {
        Product product = productMapper.toEntity(productRequest);

        productRequest.getImages().forEach(imageURL -> {
            ProductImage productImage = new ProductImage();
            productImage.setImageURL(imageURL);
            product.addImage(productImage);
        });

        Product persistedProduct = productRepository.save(product);

        productRequest.getVariants().forEach(productVariantRequest -> {
            ProductVariant productVariant = productVariantMapper.toEntity(productVariantRequest);
            productVariant.setProductId(persistedProduct.getId());

            ProductVariant persistedVariant = productVariantRepository.save(productVariant);

            ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8082/api/v1/discount",
                    new ProductDiscountRequest(persistedProduct.getId(),
                            persistedVariant.getId(),
                            productVariantRequest.getDiscountType(),
                            productVariantRequest.getDiscount(),
                            productVariantRequest.getStartDate(),
                            productVariantRequest.getEndDate()),
                    String.class);
        });
    }

    public ProductResource getProduct(Long productId) {
        return productMapper.toResource(productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with id " + productId + " doesn't exists")));
    }

    public ProductVariantResource getProductByVariantId(Long productVariantId) {
        return productVariantMapper.toResource(productVariantRepository.findById(productVariantId).orElseThrow(() -> new ResourceNotFoundException("Product with variant id " + productVariantId + "doesn't exists")));
    }

    public void deleteProduct(Long productId) {
        //TODO: Find by ID..if null send response with  404 status code
        productRepository.deleteById(productId);
    }


}
