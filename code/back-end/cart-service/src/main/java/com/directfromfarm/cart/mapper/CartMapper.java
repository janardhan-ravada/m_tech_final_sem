package com.directfromfarm.cart.mapper;

import com.directfromfarm.cart.entity.Cart;
import com.directfromfarm.cart.request.CartRequest;
import com.directfromfarm.cart.resource.CartResource;
import com.directfromfarm.cart.resource.DiscountResource;
import com.directfromfarm.cart.restobj.ProductDiscountResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class CartMapper {

    @Autowired
    private RestTemplate restTemplate;


    public Cart toEntity(CartRequest cartRequest) {
        Cart cart = new Cart();

        cart.setConsumerId(cartRequest.getConsumerId());
        cart.setProductId(cartRequest.getProductId());
        cart.setProductVariantId(cartRequest.getProductVariantId());
        cart.setQuantity(cartRequest.getQuantity());

        return cart;
    }

    public CartResource toResource(Cart cart) {
        CartResource cartResource = new CartResource();

        cartResource.setCartId(cart.getId());
        cartResource.setProductId(cart.getProductId());
        cartResource.setProductVariantId(cart.getProductVariantId());
        cartResource.setQuantity(cart.getQuantity());

        ProductDiscountResource discountResource = restTemplate.getForObject("http://localhost:8082/api/v1/discount?product=" + cart.getProductId() + "&product_variant=" + cart.getProductVariantId(), ProductDiscountResource.class);

        cartResource.setUnitPrice(discountResource.getUnitPrice());
        cartResource.setUnitPriceWithDiscount(discountResource.getUnitPriceWithDiscount());
        cartResource.setDiscounts(discountResource.getDiscounts().stream().map(restDiscount -> new DiscountResource(restDiscount.getDiscountType(), restDiscount.getDiscountAmount(), restDiscount.getOfferId(), restDiscount.getStartDate(), restDiscount.getEndDate())).collect(Collectors.toSet()));
        return cartResource;
    }
}
