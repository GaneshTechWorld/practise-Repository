package com.wipro.M2M_Student_Course.dto;

import lombok.Data;
import java.util.List;
@Data
public class StudentResponse {
    private String firstName;
    private String lastName;
    private List<CourseResponse> coursesResponseList;

}
