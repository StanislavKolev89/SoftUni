package com.example.gira.web;

import com.example.gira.model.Binding.TaskAddBindingModel;
import com.example.gira.model.service.TaskAddService;
import com.example.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addTask() {
        return "add-task";
    }

    @PostMapping("/add")
    public String addTaskConfirm(@Valid TaskAddBindingModel taskAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:add";
        }
        taskService.saveTask(modelMapper.map(taskAddBindingModel, TaskAddService.class));

        return "redirect:/home";
    }

    @GetMapping("/progress/{id}")
    public String changeProgress(@PathVariable Long id) {

        taskService.changeProgress(id);
        return "redirect:/home";
    }

    @ModelAttribute("taskAddBindingModel")
    public TaskAddBindingModel taskAddBindingModel() {
        return new TaskAddBindingModel();
    }
}
