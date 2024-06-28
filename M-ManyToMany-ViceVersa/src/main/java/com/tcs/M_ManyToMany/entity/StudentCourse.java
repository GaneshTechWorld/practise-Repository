package com.tcs.M_ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
@Entity
@Table(name="student_course")
@Data
public class StudentCourse  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_course_id")
    private Long studentCourseId;
    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;
}
/*You are seeing repeated data in your JSON output because of how your Student and StudentCourse classes
 are related to each other. When you convert these objects to JSON, they keep referring back to each
 other in an endless loop.
 Why This Happens
Student has a list of StudentCourse.
StudentCourse has a reference to Student.
When converting to JSON, Student includes StudentCourse.
Then, StudentCourse tries to include Student again.
This repeats forever, causing the nested JSON structure.
 */