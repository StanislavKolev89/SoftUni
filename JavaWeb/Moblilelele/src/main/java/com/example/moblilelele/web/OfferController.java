package com.example.moblilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferController {

    @GetMapping("/offers/add")
    public String addOfferBlank(){
        return "offer-add";
    }

    @GetMapping("/offers/all")
    public String getAllOffers(){
        return "offers";
    }
}
