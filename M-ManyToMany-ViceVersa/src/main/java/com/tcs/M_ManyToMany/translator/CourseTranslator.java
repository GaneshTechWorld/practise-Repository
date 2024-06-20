package com.tcs.M_ManyToMany.translator;

import com.tcs.M_ManyToMany.dto.CourseRequsestDto;
import com.tcs.M_ManyToMany.dto.CourseResponseDto;
import com.tcs.M_ManyToMany.entity.Course;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
@Component
public class CourseTranslator {
  /*  @Autowired
    static
    ModelMapper modelMapper;
    public Course dtoToCourse(CourseRequsestDto courseRequsestDto){
       Course course = new Course();
       modelMapper.map(courseRequsestDto,course);
       return course;
    }*/

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public CourseTranslator(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Course dtoToCourse(CourseRequsestDto courseDTO) {
        return modelMapper.map(courseDTO, Course.class);
    }


    public  static CourseResponseDto courseToResponseDto(Course course){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course,CourseResponseDto.class);
    }


}
