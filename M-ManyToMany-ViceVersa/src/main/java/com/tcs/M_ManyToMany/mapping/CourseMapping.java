package com.tcs.M_ManyToMany.mapping;

import com.tcs.M_ManyToMany.dto.CourseRequsest;
import com.tcs.M_ManyToMany.dto.CourseResponse;
import com.tcs.M_ManyToMany.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CourseMapping {
    CourseMapping INSTANCE = Mappers.getMapper(CourseMapping.class);
    @Mapping(target = "courseId", ignore = true)
    void updateCourseFromRequest(Course courseRequest, @MappingTarget Course course);
    CourseResponse courseEntityToResponse(Course course);
    Course courseRequestToCourseEntity(CourseRequsest courseRequsest);
}
