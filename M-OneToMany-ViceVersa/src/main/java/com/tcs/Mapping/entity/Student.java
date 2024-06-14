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
    public String studentName;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="student_id")
    private List<Laptop> laptops;

   /* @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="student_idi")  //student_id named column will be created in laptop table
    private List<Laptop> laptops;
    also commented
     /* @ManyToOne
    @JoinColumn(name="student_id") //specfied foreign key column
    public Student student;  other wise this will also created one column
    */
}
