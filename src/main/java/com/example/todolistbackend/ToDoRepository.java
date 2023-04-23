package com.example.todolistbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    int countByStatus(ToDoStatus status);

    List<ToDo> findTop3ByStatusIsNotOrderByDueDateAsc(ToDoStatus status);

    List<ToDo> findAllByStatus(ToDoStatus status);

}
