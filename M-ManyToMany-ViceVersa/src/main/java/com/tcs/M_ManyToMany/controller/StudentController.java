package com.tcs.M_ManyToMany.controller;

import com.tcs.M_ManyToMany.dto.StudentRequestDto;
import com.tcs.M_ManyToMany.dto.StudentSearchDto;
import com.tcs.M_ManyToMany.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "saveStudent", consumes = "application/json")
    public ResponseEntity<Object> saveStudentInfo(@Valid @RequestBody StudentRequestDto student, BindingResult bindingResult) {
        System.out.println("Received student data: " + student);
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessageBuilder = new StringBuilder("Validation failed:\n");
            bindingResult.getFieldErrors().forEach(error -> {
                String fieldName = error.getField();
                String errorMessage = error.getDefaultMessage();
                errorMessageBuilder.append(fieldName).append(": ").append(errorMessage).append("\n");
            });
            return ResponseEntity.badRequest().body(errorMessageBuilder.toString());
        }
         studentService.saveStudent(student);
        return ResponseEntity.ok("Student saved successfully");
    }
    @PostMapping(value="getStudentSearch")
    public ResponseEntity<Object> getStudentSearch(@RequestBody StudentSearchDto student){
        return new ResponseEntity<>( studentService.getStudentSearchData(student), HttpStatusCode.valueOf(200));
    }
}
