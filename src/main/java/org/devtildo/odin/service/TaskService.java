package org.devtildo.odin.service;

import org.devtildo.odin.model.Task;
import org.devtildo.odin.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> taskObj = taskRepository.findById(id);
        return taskObj.get();
    }

    public Task createTask(Task obj) {
        return taskRepository.save(obj);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> taskObj = taskRepository.findById(id);
        if (taskObj.isPresent()) {
            Task task = taskObj.get();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        } else {
            throw new RuntimeException(STR."Task not found with id \{id}");
        }
    }

    public void deleteTask(Long id) {
        Task obj = findById(id);
        taskRepository.delete(obj);
    }

}
