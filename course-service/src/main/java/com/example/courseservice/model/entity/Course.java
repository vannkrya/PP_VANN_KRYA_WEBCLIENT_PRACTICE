package com.example.courseservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(length = 200)
    private String courseName;

    @Column(length = 200)
    private String courseCode;

    @Column(length = 200)
    private String description;

    @Column(length = 200)
    private String instructor;

}
