package com.tcs.Mapping.controller;

import com.tcs.Mapping.entity.Student;
import com.tcs.Mapping.search.StudentSearchRequest;
import com.tcs.Mapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value="saveStudent", consumes = "application/json")
    public ResponseEntity<Object> saveStudentInfo(@RequestBody Student student){
        studentService.saveStudentDetails(student);
        return new ResponseEntity<>("Hello", HttpStatusCode.valueOf(200));
    }


    @PostMapping(value="getSearch")
    public ResponseEntity<Object> getStudentInfo(@RequestBody StudentSearchRequest student){
        return new ResponseEntity<>(studentService.findStudentsByLaptopName(student.getLaptopName()), HttpStatusCode.valueOf(200));
    }
}
