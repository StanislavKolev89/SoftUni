package com.example.regexam.controller;

import com.example.regexam.service.SongService;
import com.example.regexam.service.UserService;
import com.example.regexam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SongService songService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public HomeController(SongService songService, CurrentUser currentUser, UserService userService) {
        this.songService = songService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage(){
        if(currentUser.getId()!=null){
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Model model){

        model.addAttribute("popSongs",songService.findPopSongs());
        model.addAttribute("rockSongs",songService.findRockSongs());
        model.addAttribute("jazzSongs",songService.findJazzSongs());
        model.addAttribute("duration",songService.findAllTime());
        model.addAttribute("userSongs",userService.findById(currentUser.getId()).getPlaylist());
        System.out.println();
        return "home";
    }


}
