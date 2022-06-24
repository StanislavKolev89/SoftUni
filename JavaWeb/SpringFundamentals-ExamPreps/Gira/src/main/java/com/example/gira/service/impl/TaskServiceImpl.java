package com.example.gira.service.impl;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.TaskEntity;
import com.example.gira.model.enums.ClassificationEnum;
import com.example.gira.model.enums.ProgressEnum;
import com.example.gira.model.service.TaskAddService;
import com.example.gira.model.view.TaskViewModel;
import com.example.gira.repository.TaskRepository;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.session.CurrentUser;
import com.example.gira.web.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final ClassificationService classificationService;

    public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository, UserService userService, CurrentUser currentUser, ClassificationService classificationService) {
        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.classificationService = classificationService;
    }

    @Override
    public void saveTask(TaskAddService taskAddService) {
        TaskEntity taskEntity = modelMapper.map(taskAddService, TaskEntity.class);
        taskEntity.setClassification(addClassification(taskAddService.getClassification()));
        taskEntity.setUser(userService.findById(currentUser.getId()));
        taskEntity.setProgress(ProgressEnum.OPEN);
        System.out.println();
        taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskViewModel> getAllTasks() {
        return taskRepository.findAll().stream().map(taskEntity -> {
            TaskViewModel taskViewModel = modelMapper.map(taskEntity, TaskViewModel.class);
            taskViewModel.setId(taskEntity.getId());
            taskViewModel.setAssignedTo(taskViewModel.getName());
            taskViewModel.setClassification(taskEntity.getClassification().getClassificationName().name());
            taskViewModel.setProgress((taskEntity.getProgress().name()));
            return taskViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public void changeProgress(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        if(taskEntity.getProgress().name().equals("COMPLETED")){
            taskRepository.delete(taskEntity);
            return;
        }
        taskEntity.setProgress(changeProgress(taskEntity.getProgress()));
        taskRepository.save(taskEntity);
    }

    private ProgressEnum changeProgress(ProgressEnum progress) {
        ProgressEnum progressEnum=null;
        switch(progress){
            case OPEN -> progressEnum=ProgressEnum.IN_PROGRESS;
            case IN_PROGRESS -> progressEnum=ProgressEnum.COMPLETED;
        }
        return progressEnum;
    }

    private ClassificationEntity addClassification(String classification) {

        return classificationService.findByClassificationName(classification).orElse(null);
    }
}
