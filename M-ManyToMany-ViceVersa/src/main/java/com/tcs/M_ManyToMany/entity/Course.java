package com.tcs.M_ManyToMany.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Entity
@Data
@Table(name="course")
public class Course {
    @Id
    @Column(name="course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    @OneToMany(mappedBy = "course")
    private List<StudentCourse>  CourseStudentList;
    @Column(name="course_name")
    private String courseName;
}
