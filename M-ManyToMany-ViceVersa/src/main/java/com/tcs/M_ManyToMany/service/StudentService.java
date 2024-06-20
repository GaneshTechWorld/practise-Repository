package com.tcs.M_ManyToMany.service;

import com.google.gson.reflect.TypeToken;
import com.tcs.M_ManyToMany.dto.*;
import com.tcs.M_ManyToMany.entity.Course;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.entity.StudentCourse;
import com.tcs.M_ManyToMany.repo.CourseRepo;
import com.tcs.M_ManyToMany.repo.StudentRepo;
import com.tcs.M_ManyToMany.translator.CourseTranslator;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
       /*List<StudentCourse> studentCourseList = new ArrayList<>();
         for(CourseRequsestDto course: courseList){
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setCourse(courseTranslator.dtoToCourse(course));
            studentCourse.setStudent(student);
            studentCourseList.add(studentCourse);
        }*/
        List<StudentCourse> studentCourseList = courseList.stream().map(courseRequsestDto -> {
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setStudent(student);
            studentCourse.setCourse(courseTranslator.dtoToCourse(courseRequsestDto));
            return studentCourse;
        }).collect(Collectors.toList());

        student.setStudentCourseList(studentCourseList);
        return studentRepository.save(student);
    }

    public List<String> getStudentSearchData(String studentSearchDto) {
        List<Student> studentList = studentRepository.findAll(studentRepository.findByCriteria(studentSearchDto)).stream().collect(Collectors.toList());
        List<String> studentL = studentList.stream()
                .map(Student::getStudentName)
                .collect(Collectors.toList());
        return studentL;
    }

    public List<StudentResponseDto> getAllStudents() {
        Optional<List<Student>> studentListFromDB = Optional.of(studentRepository.findAll());
        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
        if (studentListFromDB.isPresent()) {
            List<Student> studentList = studentListFromDB.get();
            List<StudentCourse> stdCourseList = new ArrayList<>();
            for (Student std : studentList) {
                StudentResponseDto studentResponseDto = new StudentResponseDto();
                List<Course> courseList = std.getStudentCourseList().stream().map(st -> st.getCourse()).collect(Collectors.toList());
                List<CourseResponseDto> c = courseList.stream().map(CourseTranslator::courseToResponseDto).collect(Collectors.toList());
                studentResponseDto.setCourseResponseDtosList(c);
                studentResponseDto.setStudentName(std.getStudentName());
                studentResponseDtoList.add(studentResponseDto);
            }
        }
        return studentResponseDtoList;
    }

    public String deleteStudentById(int studentId) {
        if (studentId >= 1) {
            Optional<Student> student = studentRepository.findById(studentId);
            if (student.isPresent()) {
                studentRepository.delete(student.get());
                return "Student Deleted Succesfully..";
            } else {
                return "No Record Found With this Id";
            }
        }
        return null;
    }
    @Transactional
    public String updateStudentById(StudentRequestDto studentRequestDto,int studentId) {
        if ( studentId >= 0) {
            Optional<Student> existingStud = studentRepository.findById(studentId);
            if (existingStud.isPresent()) {
                Student existingStudent = existingStud.get();
                Optional.of(studentRequestDto.getStudentName()).ifPresent(existingStudent::setStudentName);
                List<Course> existingCoursesList = existingStudent.getStudentCourseList().stream().map(st->st.getCourse()).collect(Collectors.toList());
                List<Course> coursesRequest = studentRequestDto.getCourseList().stream().map(studentRequest->{return courseTranslator.dtoToCourse(studentRequest);}).collect(Collectors.toList());

                /*for(int i=0;i<existingCoursesList.size();i++){
                    if(!coursesRequest.get(i).getCourseName().equals("")){
                        existingCoursesList.get(i).setCourseName(coursesRequest.get(i).getCourseName());
                    }
                }*/
                Type listType = new TypeToken<List<Course>>() {}.getType();
                modelMapper.typeMap(Course.class, Course.class).addMappings(mapper -> {
                    mapper.skip(Course::setCourseId); // Skip courseId mapping
                });
                for(int i=0;i<existingCoursesList.size();i++){
                    Course existingC = existingCoursesList.get(i);
                    Course requestC = coursesRequest.get(i);
                    if(!requestC.getCourseName().equals("")){
                        modelMapper.map(requestC,existingC);
                    }
                }
                studentRepository.save(existingStudent);
                return "Student Saved Succesfully...";
            } else
                return "No Student Found With This Id...";
        }else
            return "Please Insert Proper Id...";
    }
}