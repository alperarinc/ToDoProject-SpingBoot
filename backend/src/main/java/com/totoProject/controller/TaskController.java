package com.totoProject.controller;


import com.totoProject.entity.Task;
import com.totoProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    public TaskService taskService;


    @PostMapping("/save")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task addTask = taskService.addTask(task);
        return new ResponseEntity<Task>(addTask, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id")Long id){
       taskService.taskById(id);
       return new ResponseEntity<Task>(HttpStatus.OK);
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> allTask = taskService.findAllTask();
        return new ResponseEntity<List<Task>>(allTask, HttpStatus.OK);
    }

}
