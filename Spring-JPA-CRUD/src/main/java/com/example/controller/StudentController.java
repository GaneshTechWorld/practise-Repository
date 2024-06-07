package com.example.controller;

import com.example.dto.StudentReqDto;
import com.example.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping(value ="/getData",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Store List By Unit Code", response = StudentReqDto.class)
    public ResponseEntity<List<StudentReqDto>> getStudentRecords() {
        return new ResponseEntity<>(studentService.getStudentInfo(),HttpStatus.OK);
    }
    @PostMapping("/saveStudent")
    public ResponseEntity<Object> saveStudent(@RequestBody  StudentReqDto studentRequest) {
        Object result = studentService.saveSingleStudent(studentRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @SneakyThrows
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentReqDto studentRequest,@PathVariable int id) {
        String result = studentService.updateSingleStudent(studentRequest,id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int id) {
        String result = studentService.deleteSingleStudent(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
