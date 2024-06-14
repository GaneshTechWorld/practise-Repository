package com.tcs.M_ManyToMany.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.util.List;
@Data
public class StudentRequestDto {
    @Pattern(regexp = "^[A-Za-z]+ [A-Za-z]+$", message = "Student name must be in the format 'FirstName LastName' and contain only letters")
    @NotBlank(message="Student Name Should Not Blank")
    private String studentName;
    @Valid
    private List<CourseRequsestDto> courseList;
}