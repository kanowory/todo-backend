package com.example.todolistbackend.dictionary;

import javax.persistence.*;

@Entity
@Table
public class Language {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String code;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
