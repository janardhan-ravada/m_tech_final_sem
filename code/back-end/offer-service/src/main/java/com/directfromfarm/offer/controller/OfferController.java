package com.directfromfarm.offer.controller;

import com.directfromfarm.offer.service.OfferService;
import com.directfromfarm.offer.request.OfferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<?> createOffer(@RequestBody OfferRequest offerRequest) {
        offerService.createOffer(offerRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
