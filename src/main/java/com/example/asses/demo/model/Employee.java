package com.example.asses.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data//for all getters and setters and for to string...
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoUrl;
    @NotEmpty(message = "please enter the name")

    private String name;

    private String department;
    private String jobtitle;
    private String performance;
    @CreationTimestamp
    private LocalDateTime joining_date;


}





