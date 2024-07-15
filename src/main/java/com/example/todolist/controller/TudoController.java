package com.example.todolist.controller;

import com.example.todolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.todolist.repository.TudoRepository;

import java.util.List;

@RestController
public class TudoController {

    @Autowired
    private TudoRepository tudoRepository;

    @GetMapping(value = "/")
    public String holamundo(){
        return "HOLA MUNDo";
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return tudoRepository.findAll();
    }
    @PostMapping(value="/savetask")
    public String saveTask(@RequestBody Task task){
        tudoRepository.save(task);
        return "Saved task";
    }

    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = tudoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        tudoRepository.save(updatedTask);
        return "Updated Task";
    }

    @DeleteMapping(value="delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deletedTask = tudoRepository.findById(id).get();
        tudoRepository.delete(deletedTask);
        return "Deleted Task";
    }
}
