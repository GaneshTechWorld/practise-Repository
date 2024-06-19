package com.wipro.M2M_Student_Course.service;

import com.wipro.M2M_Student_Course.dto.StudentRequest;
import com.wipro.M2M_Student_Course.dto.StudentResponse;
import com.wipro.M2M_Student_Course.dto.StudentSearch;
import com.wipro.M2M_Student_Course.entity.Course;
import com.wipro.M2M_Student_Course.entity.Student;
import com.wipro.M2M_Student_Course.repository.StudentRepository;
import com.wipro.M2M_Student_Course.translator.CourseTranslator;
import com.wipro.M2M_Student_Course.translator.StudentTranslator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentTranslator studentTranslator;

    @Autowired
    CourseTranslator courseTranslator;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;
    public void saveStudent(StudentRequest studentRequest){
        if(studentRequest != null ) {
            studentRepository.save(studentTranslator.requestToStudentEntity(studentRequest));
        }
    }
    public Object updateStudent(int studentId,StudentRequest stud){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent())
            return "Invalid Id..";
        Student studentEntity = studentOptional.get();
        if(!stud.getFirstName().equals(""))
            studentEntity.setFirstName(stud.getFirstName());
        if(!stud.getLastName().equals(""))
           studentEntity.setLastiName(stud.getLastName());
        List<Course> existingCourses =  studentEntity.getCoursesList();
        List<Course> coursesRequestList = stud.getCoursesRequestList().stream().map(CourseTranslator::requestToCourseEntity).collect(Collectors.toList());
        for (int i = 0; i < existingCourses.size(); i++) {
            Course existingCourse = existingCourses.get(i);
            Course requestCourse = coursesRequestList.get(i);
            if(!requestCourse.getCourseName().equals(""))
                Optional.ofNullable(requestCourse.getCourseName()).ifPresent(existingCourse::setCourseName);
            if(!requestCourse.getCourseMode().equals(""))
                Optional.ofNullable(requestCourse.getCourseMode()).ifPresent(existingCourse::setCourseMode);
        }
        return studentRepository.save(studentEntity);
    }
    public List<StudentResponse> getStudentList(){
        List<StudentResponse> studentRequestList = new ArrayList<>();
        List<Student> existingStudentList = studentRepository.findAll();
        for(Student student : existingStudentList){
            StudentResponse demoStud = new StudentResponse();
            demoStud.setFirstName(student.getFirstName());
            demoStud.setLastName(student.getLastiName());
            demoStud.setCoursesResponseList(student.getCoursesList().stream().map(st->courseTranslator.courseEntityToResponse(st)).collect(Collectors.toList()));
            studentRequestList.add(demoStud);
        }
        return studentRequestList;
    }
    public String deleteStudentById(int studentId){
        if(studentId <= 0 ){
            return  "Please Insert Proper Student Id";
        }else{
            Optional<Student>  optionalStudent = studentRepository.findById(studentId);
            if(optionalStudent.isPresent()){
                studentRepository.deleteById(studentId);
                return "Student Deleted Succesfully..";
            }else
                return "Student Not Found With Given Student Id";
        }
    }
    public List<StudentResponse> getStudentSearchData(StudentSearch studentSearch) {
        List<Student> studentList = studentRepository.findAll(studentRepository.findByCriteria(studentSearch)).stream().collect(Collectors.toList());
        List<StudentResponse> studentRequestList = new ArrayList<>();
        List<Student> existingStudentList = studentRepository.findAll();
        for(Student student : studentList){
            StudentResponse demoStud = new StudentResponse();
            demoStud.setFirstName(student.getFirstName());
            demoStud.setLastName(student.getLastiName());
            demoStud.setCoursesResponseList(student.getCoursesList().stream().map(st->courseTranslator.courseEntityToResponse(st)).collect(Collectors.toList()));
            studentRequestList.add(demoStud);
        }
        return studentRequestList;
    }
}
