package com.example.moblilelele.web;

import com.example.moblilelele.model.dto.OfferDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @ModelAttribute("offerModel")
    public OfferDto offerDtoInit() {
        return new OfferDto();
    }

    @GetMapping("/all")
    public String getAllOffers() {
        return "offers";
    }


    @GetMapping("/add")
    public String addOfferBlank(@Valid OfferDto offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerDto).
                    addFlashAttribute("org.springframework.validation.BindingResult.offerDto", bindingResult);
            return "redirect:offer-add";
        }
        return "offer-add";
    }

}
