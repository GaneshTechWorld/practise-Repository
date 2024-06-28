package com.tcs.M_ManyToMany.dto;

import lombok.Data;
import java.util.Date;

@Data
public class CourseResponse {
    private String courseName;
    private  String courseMode;
    private int  coursePrice;
    private double totalCourseMonths;
    private String courseDescription;
    private String courseFaulty;
    private Date courseStartDate;
}
