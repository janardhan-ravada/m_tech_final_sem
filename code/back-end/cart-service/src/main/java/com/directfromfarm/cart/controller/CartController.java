package com.directfromfarm.cart.controller;

import com.directfromfarm.cart.request.CartRequest;
import com.directfromfarm.cart.resource.CartResource;
import com.directfromfarm.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProductToCart(@RequestBody CartRequest cartRequest) {
        cartService.addProductToCart(cartRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<CartResource>> getCartForConsumer(@RequestParam(value = "consumer") Long consumerId) {
        return new ResponseEntity<>(cartService.getCartProductsByConsumerId(consumerId), HttpStatus.OK);
    }
}
