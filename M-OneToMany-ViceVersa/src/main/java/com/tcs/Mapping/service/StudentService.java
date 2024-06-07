package com.tcs.Mapping.service;

import com.tcs.Mapping.entity.Student;
import com.tcs.Mapping.repo.LaptopRepo;
import com.tcs.Mapping.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Object saveStudentDetails(Student studentInfo){

       if(studentInfo == null){
           return "Book Not Added To Save..";
       }
       else{
           studentRepo.save(studentInfo);
       }
       return null;
    }
}
