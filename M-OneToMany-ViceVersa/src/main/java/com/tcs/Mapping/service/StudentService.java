package com.tcs.Mapping.service;

import com.tcs.Mapping.entity.Laptop;
import com.tcs.Mapping.entity.Student;
import com.tcs.Mapping.repo.LaptopRepo;
import com.tcs.Mapping.repo.StudentRepo;
import com.tcs.Mapping.search.StudentSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private LaptopRepo laptopRepo;

    public Object saveStudentDetails(Student studentInfo) {

        if (studentInfo == null) {
            return "Book Not Added To Save..";
        } else {
            Student stud = new Student();
            stud.setStudentName(studentInfo.getStudentName());
            stud.setLaptops(studentInfo.getLaptops());
            studentRepo.save(stud);
            return null;
        }
    }
    public List<Student> findStudentsByLaptopName(String laptopName) {
        return studentRepo.findAll(studentRepo.hasLaptopName(laptopName));
    }
}