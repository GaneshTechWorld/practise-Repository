package com.tcs.M_ManyToMany.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class CourseRequsestDto {
    @Pattern(regexp = "^[A-Za-z]+$", message = "Course name must contain only letters")
    @NotBlank(message="course Name should Not Be Blank..")
    private String courseName;
}
