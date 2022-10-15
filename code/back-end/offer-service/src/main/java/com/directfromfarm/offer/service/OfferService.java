package com.directfromfarm.offer.service;

import com.directfromfarm.offer.entity.Offer;
import com.directfromfarm.offer.entity.ProductDiscount;
import com.directfromfarm.offer.mappers.OfferMapper;
import com.directfromfarm.offer.mappers.ProductDiscountMapper;
import com.directfromfarm.offer.repository.OfferRepository;
import com.directfromfarm.offer.repository.ProductDiscountRepository;
import com.directfromfarm.offer.request.OfferRequest;
import com.directfromfarm.offer.restobj.ProductResource;
import com.directfromfarm.offer.restobj.ProductVariantResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ProductDiscountRepository productDiscountRepository;

    @Autowired
    private OfferMapper offerMapper;

    @Autowired
    private ProductDiscountMapper productDiscountMapper;

    @Autowired
    private RestTemplate restTemplate;

    public void createOffer(OfferRequest offerRequest) {
        Offer offer = offerRepository.save(offerMapper.toEntity(offerRequest));

        offerRequest.getProducts().forEach(productDisc -> {
            ProductDiscount productDiscount = productDiscountMapper.toEntity(productDisc);
            productDiscount.setOfferId(offer.getId());


           /* TODO: This is not needed. Remove column from product_discount table as there may be many discounts applied on a product

            double priceWithDiscount = 0.0;

            ProductResource productResource = restTemplate.getForObject("http://localhost:8081/api/v1/product/" + productDisc.getProductId(), ProductResource.class);

            ProductVariantResource variant = productResource.getVariants().stream().filter(productVariantResource -> productVariantResource.getId().equals(productDisc.getProductVariantId())).findFirst().get();

            if (productDisc.getDiscountType().equals("RS")) {
                priceWithDiscount = variant.getUnitPrice() - productDisc.getDiscountAmount();
            } else if (productDisc.getDiscountType().equals("%")) {
                priceWithDiscount = variant.getUnitPrice() - (variant.getUnitPrice() * productDisc.getDiscountAmount() / 100);
            }
            productDiscount.setUnitPriceWithDiscount(priceWithDiscount);*/

            productDiscountRepository.save(productDiscount);
        });
    }
}
