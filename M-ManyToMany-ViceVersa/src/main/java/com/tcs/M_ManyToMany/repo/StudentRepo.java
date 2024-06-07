package com.tcs.M_ManyToMany.repo;

import com.tcs.M_ManyToMany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
