package com.wipro.M2M_Student_Course.controller;

import com.wipro.M2M_Student_Course.dto.StudentRequest;
import com.wipro.M2M_Student_Course.dto.StudentResponse;
import com.wipro.M2M_Student_Course.dto.StudentSearch;
import com.wipro.M2M_Student_Course.entity.Student;
import com.wipro.M2M_Student_Course.exception.InvalidQueryException;
import com.wipro.M2M_Student_Course.service.StudentService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "saveStudent", consumes = "application/json")
    @ApiOperation(value = "Save Api for student",response = Student.class)
    public ResponseEntity<Object> saveStudentInfo(@Valid @RequestBody StudentRequest student, BindingResult bindingResult) {
        try {
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
        }catch(Exception ex){
            return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "updateStudent", consumes = "application/json")
    @ApiOperation(value = "Update Api for student",response = Student.class)
    public ResponseEntity<Object> updateStudent(@RequestBody StudentRequest student,@RequestParam int studentId){
        try {
            System.out.println("Student Id : " + studentId);
            System.out.println("Received student data: " + student);
            return new ResponseEntity<>( studentService.updateStudent(studentId,student), HttpStatusCode.valueOf(200));
        }catch(Exception ex){
            return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("getStudentList")
    @ApiOperation(value = "Get Student List Api")
    public ResponseEntity<Object> getStudents(){
        try {
            return new ResponseEntity<>(studentService.getStudentList(), HttpStatusCode.valueOf(200));
        }catch(Exception ex){
            return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("deleteStudent")
    @ApiOperation(value="Delete Student Api")
    public ResponseEntity<Object> deleteStudent(int studentId){
        try {
            return new ResponseEntity<>(studentService.deleteStudentById(studentId), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("getStudents")
    @ApiOperation(value = "Get Student List Based On Search Criteria")
    public ResponseEntity<Object> getStudentBasedOnSearch(@RequestBody StudentSearch studentSearch){
        try {
            List<StudentResponse> studentResponses = studentService.getStudentSearchData(studentSearch);
            return new ResponseEntity<>(studentResponses,HttpStatus.OK);
        } catch (InvalidQueryException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
