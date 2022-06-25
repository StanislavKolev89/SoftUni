package com.example.regexam.controller;

import com.example.regexam.model.binding.SongAddBindingModel;
import com.example.regexam.model.service.AddSongService;
import com.example.regexam.service.SongService;
import com.example.regexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {

    private final ModelMapper modelMapper;
    private final SongService songService;
    private final UserService userService;


    public SongController(ModelMapper modelMapper, SongService songService, UserService userService) {
        this.modelMapper = modelMapper;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addSongPage() {
        return "song-add";
    }

    @PostMapping("/add")
    public String AddSongConfirm(@Valid SongAddBindingModel songAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songAddBindingModel", songAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel", bindingResult);
            return "redirect:add";
        }

        songService.saveSong(modelMapper.map(songAddBindingModel, AddSongService.class));

        return "redirect:/";
    }

    @ModelAttribute("songAddBindingModel")
    public SongAddBindingModel songAddBindingModel() {
        return new SongAddBindingModel();
    }


    @GetMapping("addToUser/{id}")
    public String addToUSer(@PathVariable Long id) {
        userService.addPlaylist(songService.findById(id));
        return "redirect:/home";
    }
}
