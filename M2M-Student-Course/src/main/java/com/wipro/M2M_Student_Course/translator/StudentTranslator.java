package com.wipro.M2M_Student_Course.translator;

import com.wipro.M2M_Student_Course.dto.StudentRequest;
import com.wipro.M2M_Student_Course.entity.Course;
import com.wipro.M2M_Student_Course.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class StudentTranslator {
     @Autowired
     public CourseTranslator courseTranslator;

     public static Student requestToStudentEntity(StudentRequest studentRequest){
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        Optional.ofNullable(studentRequest.getFirstName()).ifPresent(student::setFirstName);
        Optional.ofNullable(studentRequest.getLastName()).ifPresent(student::setLastiName);
        List<Course> courseList = studentRequest.getCoursesRequestList().stream().map(CourseTranslator::requestToCourseEntity).collect(Collectors.toList());
        student.setCoursesList(courseList);
        return student;
     }
}
