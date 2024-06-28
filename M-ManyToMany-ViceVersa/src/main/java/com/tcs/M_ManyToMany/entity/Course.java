package com.tcs.M_ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
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
    @Column(name="course_mode")
    private  String courseMode;
    @Column(name="course_price")
    private int  coursePrice;
    @Column(name="course_months")
    private double totalCourseMonths;
    @Column(name="course_description")
    private String courseDescription;

    @Column(name="course_faculty")
    private String courseFaulty;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy")
    @Column(name = "course_start_date")
    private Date courseStartDate;
}
