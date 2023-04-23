package com.example.todolistbackend.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> list(String order) {
        if (order == null) {
            return toDoRepository.findAll();
        }

        switch(order){
            case "asc":
                return toDoRepository.findAll(
                        Sort.by(Sort.Direction.ASC, "dueDate"));
            case "desc":
                return toDoRepository.findAll(
                        Sort.by(Sort.Direction.DESC, "dueDate"));
            default:
                return toDoRepository.findAll();
        }
    }

    public ToDo get(Integer id){
        return toDoRepository.findById(id).get();
    }

    public ToDo create(String title, String dueDate){
        ToDo newToDo = new ToDo();
        newToDo.setTitle(title);
        newToDo.setDueDate(dueDate);
        newToDo.setStatus(ToDoStatus.NEW);
        return toDoRepository.save(newToDo);
    }

    public ToDo update(ToDo request){
        ToDo updateToDo = toDoRepository.findById(request.getId())
                        .orElseThrow();
        updateToDo.setTitle(request.getTitle());
        updateToDo.setDueDate(request.getDueDate());
        updateToDo.setStatus(request.getStatus());
        return toDoRepository.save(updateToDo);
    }

    public void delete(Integer id){
        toDoRepository.deleteById(id);
    }


    public int count(ToDoStatus status) {
        return toDoRepository.countByStatus(status);
    }

    public List<ToDo> upcoming() {
        return toDoRepository.findTop3ByStatusIsNotOrderByDueDateAsc(
                ToDoStatus.COMPLETED
        );
    }

    public List<ToDo> search(ToDoStatus status) {
        return toDoRepository.findAllByStatus(status);
    }
}
