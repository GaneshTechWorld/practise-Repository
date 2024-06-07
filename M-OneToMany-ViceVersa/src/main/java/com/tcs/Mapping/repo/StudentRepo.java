package com.tcs.Mapping.repo;

import com.tcs.Mapping.entity.Laptop;
import com.tcs.Mapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
