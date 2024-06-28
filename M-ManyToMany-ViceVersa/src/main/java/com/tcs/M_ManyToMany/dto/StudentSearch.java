package com.tcs.M_ManyToMany.dto;
import lombok.Data;
@Data
public class StudentSearch {
    private String studentFirstName;
    private String studentLastName;
    private String studentMobileNumber;
    private String studentMailId;
    private Integer courseId;
    private String courseName;
    private  String courseMode;
    private int  coursePrice;
    private double totalCourseMonths;
    private String courseFaulty;
}
