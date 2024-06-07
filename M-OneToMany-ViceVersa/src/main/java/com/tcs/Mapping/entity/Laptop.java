package com.tcs.Mapping.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

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
