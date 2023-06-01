package com.example.todo_application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "list")
public class ToDoList {

    @Id
    private int list_id;

    @Column(unique = true)
    private String title;

    private String list_description;

}
