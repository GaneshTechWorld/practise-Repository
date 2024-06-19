package com.wipro.M2M_Student_Course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentSearch {
 private String studentFirstName;
 private String studentLastname;
 private String courseName;
 private String courseMode;
}
