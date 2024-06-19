package com.tcs.M_ManyToMany.repo;

import com.tcs.M_ManyToMany.entity.Course;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.entity.StudentCourse;
import com.tcs.M_ManyToMany.dto.StudentSearchDto;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Serializable>, JpaSpecificationExecutor<Student> {
     default Specification<Student> findByCriteria(final String courseName) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if(StringUtils.isNotEmpty(courseName)) {
                Join<Student, StudentCourse> attMapperJoin = root.join("studentCourseList", JoinType.INNER);
                Join<StudentCourse, Course> studentCourseCourseJoin = attMapperJoin.join("course");
                Expression<String> courseNameInTable = studentCourseCourseJoin.get("courseName");
                Expression<String> caseInSensitiveForCourseName =criteriaBuilder.lower(courseNameInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveForCourseName,courseName.toLowerCase()));
            }
            query.distinct(true);
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }
}