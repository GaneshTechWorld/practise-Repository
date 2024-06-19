package com.wipro.M2M_Student_Course.translator;

import com.wipro.M2M_Student_Course.dto.CourseRequest;
import com.wipro.M2M_Student_Course.dto.CourseResponse;
import com.wipro.M2M_Student_Course.entity.Course;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
public class CourseTranslator {
    public static Course requestToCourseEntity(CourseRequest courseRequest) {
        Course course = new Course();
        Optional.ofNullable(courseRequest.getCourseName()).ifPresent(course::setCourseName);
        Optional.ofNullable(courseRequest.getCourseMode()).ifPresent(course::setCourseMode);
        return course;
    }
    public static CourseResponse courseEntityToResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse();
        Optional.ofNullable(course.getCourseMode()).ifPresent(courseResponse::setCourseMode);
        Optional.ofNullable(course.getCourseName()).ifPresent(courseResponse::setCourseName);
        return courseResponse;
    }
}
