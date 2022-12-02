package com.directfromfarm.offer.service;

import com.directfromfarm.offer.entity.ProductDiscount;
import com.directfromfarm.offer.mappers.ProductDiscountMapper;
import com.directfromfarm.offer.repository.ProductDiscountRepository;
import com.directfromfarm.offer.request.ProductDiscountRequest;
import com.directfromfarm.offer.resource.DiscountResource;
import com.directfromfarm.offer.resource.ProductDiscountResource;
import com.directfromfarm.offer.restobj.ProductVariantResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DiscountService {

    @Autowired
    private ProductDiscountRepository productDiscountRepository;

    @Autowired
    private ProductDiscountMapper productDiscountMapper;

    @Autowired
    private RestTemplate restTemplate;

    public ProductDiscountResource getProductDiscount(Long productId, Long productVariantId) {
        Set<ProductDiscount> productDiscounts = productDiscountRepository.findByProductIdAndProductVariantId(productId, productVariantId);

        ProductDiscountResource productDiscountResource = new ProductDiscountResource();
        productDiscountResource.setProductId(productId);
        productDiscountResource.setProductVariantId(productVariantId);

        Set<DiscountResource> discounts = new HashSet<>();
        ProductVariantResource variant = restTemplate.getForObject("http://localhost:9191/api/v1/product?product_variant=" + productVariantId, ProductVariantResource.class);
        productDiscountResource.setUnitPrice(variant.getUnitPrice());
        AtomicReference<Double> unitPriceWithDiscount = new AtomicReference<>(variant.getUnitPrice());
        productDiscounts.forEach(productDiscount -> {
            DiscountResource discountResource = new DiscountResource();
            discountResource.setDiscountType(productDiscount.getDiscountType());
            discountResource.setDiscountAmount(productDiscount.getDiscountAmount());
            discountResource.setStartDate(productDiscount.getDiscountStartDate());
            discountResource.setEndDate(productDiscount.getDiscountEndDate());
            discountResource.setOfferId(productDiscount.getOfferId());

            discounts.add(discountResource);

            if (productDiscount.getDiscountType().equals("RS")) {
                unitPriceWithDiscount.set(unitPriceWithDiscount.get() - productDiscount.getDiscountAmount());
            } else if (productDiscount.getDiscountType().equals("%")) {
                unitPriceWithDiscount.set(unitPriceWithDiscount.get() - (unitPriceWithDiscount.get() * productDiscount.getDiscountAmount() / 100));
            }
        });

        productDiscountResource.setDiscounts(discounts);
        productDiscountResource.setUnitPriceWithDiscount(unitPriceWithDiscount.get());

        return productDiscountResource;
    }

    public void addProductDiscount(ProductDiscountRequest productDiscountRequest) {
        productDiscountRepository.save(productDiscountMapper.toEntity(productDiscountRequest));
    }
}
