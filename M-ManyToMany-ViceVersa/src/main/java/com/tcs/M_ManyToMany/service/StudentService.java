package com.tcs.M_ManyToMany.service;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.repo.StudentRepo;
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
