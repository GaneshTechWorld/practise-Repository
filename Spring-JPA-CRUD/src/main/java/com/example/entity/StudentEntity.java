package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private Integer studentId;
    @Column(name="st_name")
    private String studentName;
    @Column(name="st_mobile")
    private String mobileNumber;
}
