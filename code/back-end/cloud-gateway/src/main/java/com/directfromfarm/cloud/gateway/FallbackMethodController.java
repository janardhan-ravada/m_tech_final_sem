package com.directfromfarm.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/productServiceFallback")
    public String productServiceFallbackMethod() {
        return "User Service is down";
    }

    @GetMapping("/cartServiceFallback")
    public String cartServiceFallbackMethod() {
        return "Cart Service is down";
    }

    @GetMapping("/offerServiceFallback")
    public String offerServiceFallbackMethod() {
        return "Offer Service is down";
    }

}
