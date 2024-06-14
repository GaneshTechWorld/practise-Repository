package com.tcs.Mapping.repo;

import com.tcs.Mapping.entity.Laptop;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.JoinType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer>, JpaSpecificationExecutor<Laptop> {

}
