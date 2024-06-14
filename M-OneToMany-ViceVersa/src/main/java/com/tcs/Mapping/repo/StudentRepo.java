package com.tcs.Mapping.repo;

import com.tcs.Mapping.entity.Laptop;
import com.tcs.Mapping.entity.Student;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student>  {
    public default Specification<Student> hasLaptopName(String laptopName) {
        return (root, query, criteriaBuilder) -> {
            Join<Student, Laptop> laptopJoin = root.join("student");
            return criteriaBuilder.equal(laptopJoin.get("laptopName"), laptopName);
        };
    }


}