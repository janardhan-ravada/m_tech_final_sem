package com.directfromfarm.cart.service;

import com.directfromfarm.cart.entity.Cart;
import com.directfromfarm.cart.mapper.CartMapper;
import com.directfromfarm.cart.repository.CartRepository;
import com.directfromfarm.cart.request.CartRequest;
import com.directfromfarm.cart.resource.CartResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartMapper cartMapper;

    public void addProductToCart(CartRequest cartRequest) {
        cartRepository.save(cartMapper.toEntity(cartRequest));
    }

    public Set<CartResource> getCartProductsByConsumerId(Long consumerId) {
        Set<Cart> cartProducts = cartRepository.findByConsumerId(consumerId);
        return cartProducts.stream().map(cart -> cartMapper.toResource(cart)).collect(Collectors.toSet());
    }

}
