package com.tcs.M_ManyToMany.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="student")
@Data
public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentRollNumber;
    @Column(name="stud_fname")
    private String studentFirstName;
    @Column(name="stud_lname")
    private String studentLastName;
    @Column(name="stu_mobile")
    private String studentMobileNumber;
    @Column(name="stud_mailid")
    private String studentMailId;
    @Column(name="stud_address")
    private String studentAddress;

    /*In ManyToMany bidirecional relation 3rd table must be crated and mappedBy is just used for understadning owning entity*/
    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private  List<StudentCourse> studentCourseList;
}
