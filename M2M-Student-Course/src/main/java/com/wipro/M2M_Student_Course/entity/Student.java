package com.wipro.M2M_Student_Course.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name="student")
public class Student {
    @Id
    @Column(name="stud_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Column(name="stud_fname")
    private String firstName;
    @Column(name="stud_lname")
    private String lastiName;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "StudentCourseJoin",
            joinColumns = @JoinColumn(name = "studid", referencedColumnName = "stud_id"),
            inverseJoinColumns = @JoinColumn(name = "courseid", referencedColumnName = "course_id")
            )
    private List<Course> coursesList;
}
