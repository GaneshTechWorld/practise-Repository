package com.tcs.M_ManyToMany.repo;

import com.tcs.M_ManyToMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {
        Optional<Course> findByCourseName(String courseName);
}
