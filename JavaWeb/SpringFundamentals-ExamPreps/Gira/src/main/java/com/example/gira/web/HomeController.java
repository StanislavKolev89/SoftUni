package com.example.gira.web;

import com.example.gira.service.TaskService;
import com.example.gira.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final TaskService taskService;
    private final CurrentUser currentUser;

    public HomeController(TaskService taskService, CurrentUser currentUser) {
        this.taskService = taskService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String indexPage() {
        System.out.println();
        if(currentUser.getId()!=null){
            return "home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("getAllTasks",taskService.getAllTasks());
        return "home";
    }




}
