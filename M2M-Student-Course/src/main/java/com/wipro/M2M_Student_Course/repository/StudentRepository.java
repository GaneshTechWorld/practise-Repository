package com.wipro.M2M_Student_Course.repository;

import com.wipro.M2M_Student_Course.dto.StudentSearch;
import com.wipro.M2M_Student_Course.entity.Course;
import com.wipro.M2M_Student_Course.entity.Student;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Serializable>, JpaSpecificationExecutor<Student> {

    default Specification<Student> findByCriteria(final StudentSearch studentSearch) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            final String courseName =  studentSearch.getCourseName();
            final String courseMode = studentSearch.getCourseMode();
            final String studentFirstName = studentSearch.getStudentFirstName();
            final String studentLastName = studentSearch.getStudentLastname();
            Join<Student, Course> attMapperJoin = root.join("coursesList", JoinType.INNER);
            if (StringUtils.isNotEmpty(courseName)) {
                Expression<String> courseNameInTable = attMapperJoin.get("courseName");
                Expression<String> caseInSensitiveForCourseName = criteriaBuilder.lower(courseNameInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveForCourseName, courseName.toLowerCase()));
            }
            if(StringUtils.isNotEmpty(courseMode)){
                Expression<String> courseModeInTable = attMapperJoin.get("courseMode");
                Expression<String> caseInSensitiveForCourseMode = criteriaBuilder.lower(courseModeInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveForCourseMode, courseMode.toLowerCase()));
            }
            if(StringUtils.isNotEmpty(studentFirstName)){
                Expression<String> studentFirstNameInTable = attMapperJoin.get("firstName");
                Expression<String> caseInSensitiveStudFirstName = criteriaBuilder.lower(studentFirstNameInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveStudFirstName, studentFirstName.toLowerCase()));
            }
            if(StringUtils.isNotEmpty(studentLastName)){
                Expression<String> studentLastNameInTable = attMapperJoin.get("lastName");
                Expression<String> caseInSensitiveStudLasstName = criteriaBuilder.lower(studentLastNameInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveStudLasstName, studentLastName.toLowerCase()));
            }
            query.distinct(true);
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }
}