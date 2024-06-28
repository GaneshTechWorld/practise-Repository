package com.tcs.M_ManyToMany.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
public class CourseRequsest {
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Course name must contain only letters and spaces")
    @NotBlank(message="course Name should Not Be Blank..")
    private String courseName;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Course mode must contain only letters")
    @NotBlank(message="course mode should Not Be Blank..")
    private  String courseMode;
    @Digits(integer = 10, fraction = 0, message = "Course price must be an integer")
    private int  coursePrice;
    @Digits(integer = 2, fraction = 2, message = "Total course months must be a number with up to 2 digits and up to 2 decimal places")
    private double totalCourseMonths;
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Course description must contain only letters and spaces")
    private String courseDescription;
    @Pattern(regexp = "^(?:Mr\\.|Dr\\.)?\\s?[A-Za-z]+(?:\\s[A-Za-z]+)?$", message = "Course faculty must contain only letters, spaces, or hyphens")
    @NotBlank(message="course faculty should Not Be Blank..")
    private String courseFaulty;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy")
    private Date courseStartDate;
}
