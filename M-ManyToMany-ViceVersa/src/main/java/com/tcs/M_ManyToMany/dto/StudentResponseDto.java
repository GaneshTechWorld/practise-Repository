package com.tcs.M_ManyToMany.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDto {
    private String studentName;
    private List<CourseResponseDto> courseResponseDtosList;
}
