package com.tcs.M_ManyToMany.service;

import com.tcs.M_ManyToMany.dto.CourseRequsestDto;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.entity.StudentCourse;
import com.tcs.M_ManyToMany.repo.CourseRepo;
import com.tcs.M_ManyToMany.repo.StudentRepo;
import com.tcs.M_ManyToMany.dto.StudentRequestDto;
import com.tcs.M_ManyToMany.dto.StudentSearchDto;
import com.tcs.M_ManyToMany.translator.CourseTranslator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private CourseTranslator courseTranslator;

    @Autowired
    private ModelMapper modelMapper;

   @Transactional
    public Student saveStudent(StudentRequestDto requestStudent) {
        Student student = new Student();
        student.setStudentName(requestStudent.getStudentName());

        List<CourseRequsestDto> courseList = requestStudent.getCourseList();
        List<StudentCourse> studentCourseList = new ArrayList<>();

        for(CourseRequsestDto course: courseList){
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setCourse(courseTranslator.dtoToCourse(course));
            studentCourse.setStudent(student);
            studentCourseList.add(studentCourse);
        }
        student.setStudentCourseList(studentCourseList);
        return studentRepository.save(student);
    }
    public  List<String>  getStudentSearchData(StudentSearchDto studentSearchDto){
       List<Student> studentList =  studentRepository.findAll(studentRepository.findByCriteria(studentSearchDto)).stream().collect(Collectors.toList());
        List<String> studentL = studentList.stream()
                .map(Student::getStudentName)
                .collect(Collectors.toList());
        return studentL;
   }
}
