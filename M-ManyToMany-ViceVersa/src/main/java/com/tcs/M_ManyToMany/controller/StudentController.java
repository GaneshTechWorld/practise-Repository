package com.tcs.M_ManyToMany.controller;

import com.tcs.M_ManyToMany.dto.StudentRequest;
import com.tcs.M_ManyToMany.dto.StudentSearch;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.service.StudentService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping(value = {"/student","/studentInfo"})
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "saveStudent", consumes = "application/json")
    @ApiOperation(value = "Student Save Api",response = Student.class)
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody StudentRequest student, BindingResult bindingResult) {
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
         studentService.saveStudentInfo(student);
        return ResponseEntity.ok("Student saved successfully");
    }
    @GetMapping("getAllStudents")
    @ApiOperation(value = "Get Api To Get All Students Informations",response = Student.class)
    public ResponseEntity<Object> getAllStudent(){
        studentService.getAllStudents();
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("deleteById")
    @ApiOperation(value = "Delete  Api To Delete Student Based On Their Id")
    public ResponseEntity<Object> deleteStudentById(@RequestParam int studentId){
        return new ResponseEntity<>(studentService.deleteStudentById(studentId),HttpStatusCode.valueOf(200));
    }
    @PutMapping("updateStudent")
    @ApiOperation(value="Update Api To Update Student Record")
    public ResponseEntity<Object> updateStudet(@RequestBody StudentRequest studentRequest, @RequestParam int studentId){
            return new ResponseEntity<>(studentService.updateStudentById(studentRequest,studentId),HttpStatusCode.valueOf(200));
    }
    @PostMapping("studentSearch")
    @ApiOperation(value = "Search Api to Search Student Based On Course Name",response = Student.class)
    public ResponseEntity<Object> getStudentSearch(@RequestBody StudentSearch studentSearch){
        return new ResponseEntity<>( studentService.getStudentSearchData(studentSearch), HttpStatusCode.valueOf(200));
    }
}
