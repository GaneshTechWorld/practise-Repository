package com.wipro.M2M_Student_Course.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.util.List;
@Data
public class StudentRequest {
    @Pattern(regexp = "^[A-Za-z]+$", message = "Student First name contain only letters")
    @NotBlank(message="Student First mame Should Not Blank")
    private String firstName;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Student last name contain only letters")
    @NotBlank(message="Student last Name Should Not Blank")
    private String lastName;
    @Valid
    private List<CourseRequest> coursesRequestList;
}
