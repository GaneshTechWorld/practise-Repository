package com.tcs.M_ManyToMany.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name="student")
@Data
public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNo;

    @Column(name="student_name")
    private String studentName;

    /*In ManyToMany bidirecional relation 3rd table must be crated and mappedBy is just used for understadning owning entity*/
    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private  List<StudentCourse> studentCourseList;
}
