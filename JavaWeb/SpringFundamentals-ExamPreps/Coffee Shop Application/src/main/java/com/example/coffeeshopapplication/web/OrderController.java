package com.example.coffeeshopapplication.web;

import com.example.coffeeshopapplication.model.binding.AddAlbumPageBindingModel;
import com.example.coffeeshopapplication.model.service.OrderAddServiceModel;
import com.example.coffeeshopapplication.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/orders/add")
    public String offerPage() {
        return "order-add";
    }

    @PostMapping("/orders/add")
    public String offerConfirm(@Valid AddAlbumPageBindingModel addAlbumPageBindingModel, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addAlbumPageBindingModel", addAlbumPageBindingModel);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.addAlbumPageBindingModel", bindingResult);
            return "redirect:orders/add";
        }
     orderService.addOrder(modelMapper.map(addAlbumPageBindingModel, OrderAddServiceModel.class));
        return "redirect:/home";

    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/home";
    }


    @ModelAttribute("addAlbumPageBindingModel")
    public AddAlbumPageBindingModel addAlbumPageBindingModel() {
        return new AddAlbumPageBindingModel();
    }
}
