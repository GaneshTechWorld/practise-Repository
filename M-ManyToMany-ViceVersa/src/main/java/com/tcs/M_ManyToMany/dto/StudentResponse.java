package com.tcs.M_ManyToMany.dto;

import lombok.Data;
import java.util.List;
@Data
public class StudentResponse {
    private String studentFirstName;
    private String studentLastName;
    private String studentMobileNumber;
    private String studentMailId;
    private String studentAddress;
    private List<CourseResponse> courseResponseList;
}
