package com.tcs.M_ManyToMany.repo;

import com.tcs.Mapping.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Integer> {
}
