package com.example.gira.service;

import com.example.gira.model.service.TaskAddService;
import com.example.gira.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void saveTask(TaskAddService taskAddService);

    List<TaskViewModel> getAllTasks();

    void changeProgress(Long id);
}
