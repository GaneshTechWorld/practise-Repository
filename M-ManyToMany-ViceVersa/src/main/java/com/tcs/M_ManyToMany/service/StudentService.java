package com.tcs.M_ManyToMany.service;

import com.tcs.M_ManyToMany.exception.NoRecordsFoundException;
import com.tcs.M_ManyToMany.dto.*;
import com.tcs.M_ManyToMany.entity.Course;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.entity.StudentCourse;
import com.tcs.M_ManyToMany.mapping.CourseMapping;
import com.tcs.M_ManyToMany.mapping.StudentMappig;
import com.tcs.M_ManyToMany.repo.CourseRepo;
import com.tcs.M_ManyToMany.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepository;
    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public void saveStudentInfo(StudentRequest requestStudent) {
        Student student = new Student();
        BeanUtils.copyProperties(requestStudent,student);
        List<CourseRequsest> courseRequestList = requestStudent.getCourseList();
       /*List<StudentCourse> studentCourseList = new ArrayList<>();
         for(CourseRequsestDto course: courseList){
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setCourse(courseTranslator.dtoToCourse(course));
            studentCourse.setStudent(student);
            studentCourseList.add(studentCourse);
        }*/
        if(!courseRequestList.isEmpty()){
            List<StudentCourse> studentCourseList = courseRequestList.stream().map(courseRequsest -> {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudent(student);
               //studentCourse.setCourse(courseTranslator.dtoToCourse(courseRequsest));
                 studentCourse.setCourse(CourseMapping.INSTANCE.courseRequestToCourseEntity(courseRequsest));
                return studentCourse;
            }).collect(Collectors.toList());
            student.setStudentCourseList(studentCourseList);
        }
        studentRepository.save(student);
    }
    public List<StudentResponse> getStudentSearchData(StudentSearch studentSearch) {
        List<Student> studentList = studentRepository.findAll(studentRepository.findByCriteria(studentSearch)).stream().collect(Collectors.toList());
        if(studentList.isEmpty()){
            throw new NoRecordsFoundException("No records found for the given search criteria");
        }
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for(Student stud : studentList){
            StudentResponse studentResponse = StudentMappig.INSTANCE.studentEntityToStudentResponse(stud);
            //List<CourseResponse> studentResponseDtoLis = stud.getStudentCourseList().stream().map(st->{return courseTranslator.courseToResponseDto(st.getCourse());}).collect(Collectors.toList());
            List<CourseResponse> courseResponseList = stud.getStudentCourseList().stream().map(st->{return CourseMapping.INSTANCE.courseEntityToResponse(st.getCourse());}).collect(Collectors.toList());
            studentResponse.setCourseResponseList(courseResponseList);
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }
    public Object getAllStudents() {
        Optional<List<Student>> optionalStudentListFromDB = Optional.of(studentRepository.findAll());
        if (optionalStudentListFromDB.isPresent()) {
            List<Student> studentListFromDB = optionalStudentListFromDB.get();
            List<StudentResponse> studentResponsesList = new ArrayList<>();
            for (Student student : studentListFromDB) {
                StudentResponse studentResponse =  StudentMappig.INSTANCE.studentEntityToStudentResponse(student);
                //List<CourseResponse> courseResponseList = student.getStudentCourseList().stream().map(st->{return courseTranslator.courseToResponseDto(st.getCourse());}).collect(Collectors.toList());
                List<CourseResponse> courseResponseList = student.getStudentCourseList().stream().map(st->{return CourseMapping.INSTANCE.courseEntityToResponse(st.getCourse());}).collect(Collectors.toList());
                studentResponse.setCourseResponseList(courseResponseList);
                studentResponsesList.add(studentResponse);
            }
            return studentResponsesList;
        }
       throw new NoRecordsFoundException("No Student Record Found");
    }
    public String deleteStudentById(int studentId) {
        if (studentId >= 1) {
            Optional<Student> student = studentRepository.findById(studentId);
            if (student.isPresent()) {
                studentRepository.delete(student.get());
                return "Student Deleted Succesfully..";
            } else {
                throw new NoRecordsFoundException("No records found for the given search criteria");
            }
        }
        return null;
    }
    @Transactional
    public String updateStudentById(StudentRequest studentRequest, int studentId) {
        if ( studentId >= 0) {
            Optional<Student> optionalStudent = studentRepository.findById(studentId);
            if (optionalStudent.isPresent()) {
                Student existingStudent = optionalStudent.get();
                StudentMappig.INSTANCE.updateStudentFromRequest(studentRequest,existingStudent);

                List<Course> existingCoursesList = existingStudent.getStudentCourseList().stream().map(st->st.getCourse()).collect(Collectors.toList());
               // List<Course> coursesRequest = studentRequest.getCourseList().stream().map(studentReq->{return courseTranslator.dtoToCourse(studentReq);}).collect(Collectors.toList());
                List<Course> coursesRequest = studentRequest.getCourseList().stream().map(studentReq->{return CourseMapping.INSTANCE.courseRequestToCourseEntity(studentReq);}).collect(Collectors.toList());
                for(int i=0;i<existingCoursesList.size();i++){
                    Course existingC = existingCoursesList.get(i);
                    Course requestC = coursesRequest.get(i);
                    if(!requestC.getCourseName().equals("")){
                        CourseMapping.INSTANCE.updateCourseFromRequest(requestC, existingC);
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