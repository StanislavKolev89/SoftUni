package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/about")
    public String showIndex(){
        return "about";
    }

    @GetMapping("/routes")
    public String showRoutes(Model model){
        model.addAttribute("routes" ,routeService.findAllRoutes());
        return "routes";
    }
}
