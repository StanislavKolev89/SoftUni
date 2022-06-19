package com.example.battleship.web;

import com.example.battleship.entity.view.ShipViewModel;
import com.example.battleship.entity.binding.BattleBindingModel;
import com.example.battleship.service.ShipService;
import com.example.battleship.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        if(currentUser.getId()==null){
            return "index";
        }
        List<ShipViewModel> allShipsOfLoggedUser = shipService.findAllShipsOfLoggedUser();
        List<ShipViewModel> allOtherShips = shipService.findAllOtherShips();
        List<ShipViewModel> allShips = Stream.concat(allOtherShips.stream(), allShipsOfLoggedUser.stream()).collect(Collectors.toList());

        model.addAttribute("userShips", allShipsOfLoggedUser);
        model.addAttribute("enemyShips", allOtherShips);
        model.addAttribute("allShips", allShips);

        return"home";
    }


    @PostMapping("/home/battle")
    public String postBattle(@Valid BattleBindingModel battleBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("battleBindingModel", battleBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.battleBindingModel", bindingResult);

            return "redirect:/";
        }

        shipService.attack(battleBindingModel.getAttackerName(), battleBindingModel.getDefenderName());
        return "redirect:/";
    }

    @ModelAttribute("battleBindingModel")
    public BattleBindingModel battleBindingModel() {
        return new BattleBindingModel();
    }

}
