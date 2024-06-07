package com.tcs.M_ManyToMany.controller;

import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.service.StudentService;
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
}
