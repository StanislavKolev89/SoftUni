package com.example.battleship.web;

import com.example.battleship.entity.binding.ShipAddBindingModel;
import com.example.battleship.entity.service.ShipAddServiceModel;
import com.example.battleship.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("shipAddBindingModel")
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }

    @GetMapping("/ships/add")
    public String addShipPage() {
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String addShipConfirm(@Valid ShipAddBindingModel shipAddBindingModel, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || shipService.existsByName(shipAddBindingModel.getName())){
            redirectAttributes.addFlashAttribute("shipAddBindingModel",shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",bindingResult);
            redirectAttributes.addFlashAttribute("isExisting",shipService.existsByName(shipAddBindingModel.getName()));
            return "redirect:/ships/add";
        }

        ShipAddServiceModel shipAddServiceModel = modelMapper.map(shipAddBindingModel, ShipAddServiceModel.class);
        shipService.addShip(shipAddServiceModel);
        return"home";
    }

}
