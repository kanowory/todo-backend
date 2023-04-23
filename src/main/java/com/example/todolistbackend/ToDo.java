package com.example.todolistbackend;

import javax.persistence.*;

@Entity
@Table(name="new_to_dos")
public class ToDo {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String dueDate;

    @Enumerated(EnumType.STRING)
    private ToDoStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public ToDoStatus getStatus() {
        return status;
    }

    public void setStatus(ToDoStatus status) {
        this.status = status;
    }
}
