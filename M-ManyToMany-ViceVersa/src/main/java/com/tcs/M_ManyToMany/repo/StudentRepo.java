package com.tcs.M_ManyToMany.repo;

import com.tcs.M_ManyToMany.entity.Course;
import com.tcs.M_ManyToMany.entity.Student;
import com.tcs.M_ManyToMany.entity.StudentCourse;
import com.tcs.M_ManyToMany.dto.StudentSearch;
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
     default Specification<Student> findByCriteria(final StudentSearch studentRequest) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if(StringUtils.isNotEmpty(studentRequest.getStudentFirstName())) {
                Expression<String> studentFNameInTable = root.get("studentFirstName");
                Expression<String> caseInsensitiveForStudentFName = criteriaBuilder.lower(studentFNameInTable);
                predicateList.add(criteriaBuilder.like(caseInsensitiveForStudentFName,  studentRequest.getStudentFirstName().toLowerCase() ));
            }
            if(StringUtils.isNotEmpty(studentRequest.getStudentLastName())) {
                Expression<String> studentLNameInTable = root.get("studentLastName");
                Expression<String> caseInsensitiveForStudentLName = criteriaBuilder.lower(studentLNameInTable);
                predicateList.add(criteriaBuilder.like(caseInsensitiveForStudentLName,  studentRequest.getStudentLastName().toLowerCase() ));
            }
            if(StringUtils.isNotEmpty(studentRequest.getStudentMailId())) {
                Expression<String> studentMailIDInTable = root.get("studentMailId");
                Expression<String> caseInsensitiveForStudentMail = criteriaBuilder.lower(studentMailIDInTable);
                predicateList.add(criteriaBuilder.like(caseInsensitiveForStudentMail,  studentRequest.getStudentMailId().toLowerCase() ));
            }
            if(StringUtils.isNotEmpty(studentRequest.getStudentMobileNumber())) {
                Expression<String> studentMobileInTable = root.get("studentMobileNumber");
                Expression<String> caseInsensitiveForStudentMobile = criteriaBuilder.lower(studentMobileInTable);
                predicateList.add(criteriaBuilder.like(caseInsensitiveForStudentMobile,  studentRequest.getStudentMobileNumber().toLowerCase() ));
            }
            Join<Student, StudentCourse> attMapperJoin = root.join("studentCourseList", JoinType.INNER);
            Join<StudentCourse, Course> studentCourseCourseJoin = attMapperJoin.join("course");
            if(StringUtils.isNotEmpty(studentRequest.getCourseName())) {
                Expression<String> courseNameInTable = studentCourseCourseJoin.get("courseName");
                Expression<String> caseInSensitiveForCourseName =criteriaBuilder.lower(courseNameInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveForCourseName,studentRequest.getCourseName().toLowerCase()));
            }
            if(StringUtils.isNotEmpty(studentRequest.getCourseMode())) {
                Expression<String> courseModeInTable = studentCourseCourseJoin.get("courseMode");
                Expression<String> caseInSensitiveForCourseMode =criteriaBuilder.lower(courseModeInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveForCourseMode,studentRequest.getCourseMode().toLowerCase()));
            }
            if(StringUtils.isNotEmpty(studentRequest.getCourseFaulty())) {
                Expression<String> courseFacultyInTable = studentCourseCourseJoin.get("courseFaulty");
                Expression<String> caseInSensitiveForCourseFaculty =criteriaBuilder.lower(courseFacultyInTable);
                predicateList.add(criteriaBuilder.like(caseInSensitiveForCourseFaculty,studentRequest.getCourseFaulty().toLowerCase()));
            }
            if (studentRequest.getCoursePrice() != 0) {
                Expression<Integer> coursePriceInTable = studentCourseCourseJoin.get("coursePrice");
                predicateList.add(criteriaBuilder.equal(coursePriceInTable, studentRequest.getCoursePrice()));
            }
            if (studentRequest.getTotalCourseMonths() !=  0) {
                Expression<Double> courseDuratioInTable = studentCourseCourseJoin.get("totalCourseMonths");
                predicateList.add(criteriaBuilder.equal(courseDuratioInTable, studentRequest.getTotalCourseMonths()));
            }
            query.distinct(true);
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }
}