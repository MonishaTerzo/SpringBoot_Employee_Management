package com.example.asses.demo.EmployeeDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;



@Data//for all getters and setters and for to string...
@Builder
public class Employeedto {




        private String photoUrl;
        private Long id;
        @NotEmpty(message="The name should be entered")
        private String name;
        private String department;
        private String jobtitle;
        private String performance;
        private LocalDateTime joining_date;




}




