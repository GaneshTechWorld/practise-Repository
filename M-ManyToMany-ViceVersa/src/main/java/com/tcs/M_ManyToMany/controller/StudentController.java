package com.tcs.M_ManyToMany.controller;

import com.tcs.M_ManyToMany.dto.StudentRequestDto;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(value = "saveStudent", consumes = "application/json")
    @ApiOperation(value = "Save Api for student",response = Student.class)
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
    @GetMapping("getAllStudents")
    @ApiOperation(value = "Get Api for getting All Students...",response = Student.class)
    public ResponseEntity<Object> getAllStudent(){
        studentService.getAllStudents();
        return   new ResponseEntity<>(studentService.getAllStudents(),HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("deleteById")
    @ApiOperation(value = "Get Api for getting All Students...")
    public ResponseEntity<Object> deleteStudentById(@RequestParam int studentId){
        return new ResponseEntity<>(studentService.deleteStudentById(studentId),HttpStatusCode.valueOf(200));
    }
    @PutMapping("updateStudent")
    @ApiOperation(value="Student Update APi")
    public ResponseEntity<Object> updateStudet(@RequestBody StudentRequestDto studentRequestDto,@RequestParam int studentId){
            return new ResponseEntity<>(studentService.updateStudentById(studentRequestDto,studentId),HttpStatusCode.valueOf(200));
    }

    @GetMapping("stdByCourseName")
    @ApiOperation(value = "Search Student Based On Course Name",response = Student.class)
    public ResponseEntity<Object> getStudentSearch(@RequestParam String courseName){
        return new ResponseEntity<>( studentService.getStudentSearchData(courseName), HttpStatusCode.valueOf(200));
    }
}
