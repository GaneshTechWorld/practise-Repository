package com.tcs.Mapping.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="student")
@Data
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    @Id
    Integer rollNo;

    @Column(name="student_name")
    String studentName;

    /*It will create 3rd table studet_laptop that contain laptop_pk and student_pk*/
    @OneToMany(mappedBy = "laptopName",cascade = CascadeType.ALL)
    private List<Laptop> laptops;
}
