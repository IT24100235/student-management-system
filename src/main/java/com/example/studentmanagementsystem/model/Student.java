package com.example.studentmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Generates getters, setters, and toString automatically
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String course;
}
