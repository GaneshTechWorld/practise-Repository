package com.tcs.M_ManyToMany.translator;

import com.tcs.M_ManyToMany.dto.CourseRequsestDto;
import com.tcs.M_ManyToMany.entity.Course;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
@Component
public class CourseTranslator {
    @Autowired
    ModelMapper modelMapper;
    public Course dtoToCourse(CourseRequsestDto courseRequsestDto){
       Course course = new Course();
       modelMapper.map(courseRequsestDto,course);
       return course;
    }
}
