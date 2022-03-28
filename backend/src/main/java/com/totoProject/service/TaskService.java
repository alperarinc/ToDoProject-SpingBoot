package com.totoProject.service;

import com.totoProject.entity.Task;
import com.totoProject.repositoriy.TaskRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepositoriy taskRepositoriy;


    public Task addTask(Task task) {

        return taskRepositoriy.save(task);
    }

    public void deleteTaskById(Long taskId) {

        taskRepositoriy.deleteById(taskId);
    }

    public Task updateTask(Task task){
        Task updateTask = taskRepositoriy.findById(task.getId()).orElse(null);
        updateTask.setId(task.getId());
        updateTask.setText(task.getText());
        updateTask.setTitle(task.getTitle());

        return taskRepositoriy.save(updateTask);
    }
    public Task taskById(Long taskId){
        return taskRepositoriy.getById(taskId);
    }


    public List<Task> findAllTask() {

        return taskRepositoriy.findAll();
    }
}
