package com.example.asses.demo.EmployeeDto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class RegistrationDto {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private String role;
}
