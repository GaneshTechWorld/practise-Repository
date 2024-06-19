package com.wipro.M2M_Student_Course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class CourseRequest {
    @Pattern(regexp = "^[A-Za-z]+$", message = "Course name contain only letters")
    @NotBlank(message="Course name Should Not Blank")
    private String courseName;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Course Mode contain only letters")
    @NotBlank(message="Course Mode Should Not Blank")
    private String courseMode;
}
