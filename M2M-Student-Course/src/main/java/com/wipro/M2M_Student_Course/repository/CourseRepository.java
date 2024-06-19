package com.wipro.M2M_Student_Course.repository;

import com.wipro.M2M_Student_Course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRepository extends JpaRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
}
