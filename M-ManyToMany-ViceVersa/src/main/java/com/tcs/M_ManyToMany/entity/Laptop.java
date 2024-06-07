package com.tcs.M_ManyToMany.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="laptop")
public class Laptop {
    @Id
    @Column(name="laptop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer authorId;

    @ManyToOne
    private Student student;

    @Column(name="laptop_name")
    String laptopName;

}
