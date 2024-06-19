package com.wipro.M2M_Student_Course.entity;

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
    @Column(name="course_name")
    private String courseName;
    @Column(name="course_mode")
    private String courseMode;
}
