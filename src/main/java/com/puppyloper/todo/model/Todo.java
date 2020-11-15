package com.puppyloper.todo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String content;

    private Boolean isDone;

    private Date createdAt;

    private Date updatedAt;
}