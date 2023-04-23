package com.example.todolistbackend.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDo> list(@RequestParam(required = false) String order){
        return toDoService.list(order);
    }

    @GetMapping("/{id}")
    public ToDo get(@PathVariable Integer id){
        return toDoService.get(id);
    }

    @PostMapping
    public ToDo create(@RequestBody ToDoCreate toDoCreate){
        return toDoService.create(
                toDoCreate.getTitle(),
                toDoCreate.getDueDate()
        );
    }

    @PutMapping
    public ToDo update(@RequestBody ToDo request){
        return toDoService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        toDoService.delete(id);
    }

    @GetMapping("/count/{status}")
    public int count(@PathVariable ToDoStatus status){
        return toDoService.count(status);
    }

    @GetMapping("/upcoming/list")
    public List<ToDo> upcoming(){
        return toDoService.upcoming();
    }

    @GetMapping("/search/{status}")
    public List<ToDo> search (@PathVariable ToDoStatus status){
        return toDoService.search(status);
    }

}
