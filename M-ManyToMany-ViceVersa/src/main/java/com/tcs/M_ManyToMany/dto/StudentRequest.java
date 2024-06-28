package com.tcs.M_ManyToMany.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.util.List;
@Data
public class StudentRequest {
    @Pattern(regexp = "^[A-Za-z\\s-]+$", message = "Student first name must contain only letters, spaces, or hyphens")
    @NotBlank(message="Student first name should Not Be Blank..")
    private String studentFirstName;
    @NotBlank(message="Student last name should Not Be Blank..")
    @Pattern(regexp = "^[A-Za-z\\s-]+$", message = "Student last name must contain only letters, spaces, or hyphens")
    private String studentLastName;
    @Pattern(regexp = "^\\+91\\s\\d{10}$", message = "Invalid phone number")
    @NotBlank(message="Student mobile number should Not Be Blank..")
    private String studentMobileNumber;
    @Email(message = "Invalid email address")
    @NotBlank(message="Student mail id should Not Be Blank..")
    private String studentMailId;
    @Pattern(regexp = "^[A-Za-z0-9\\s,.-]+$", message = "Student address must contain only letters, numbers, spaces, commas, periods, and hyphens")
    @NotBlank(message="student address should Not Be Blank..")
    private String studentAddress;
    @Valid
    private List<CourseRequsest> courseList;
}