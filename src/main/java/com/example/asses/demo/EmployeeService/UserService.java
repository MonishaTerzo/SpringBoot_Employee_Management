package com.example.asses.demo.EmployeeService;


import com.example.asses.demo.EmployeeDto.RegistrationDto;
import com.example.asses.demo.model.UserEntity;

import java.util.List;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    UserEntity findByRole(String username);
    void delete(long id);
    List<UserEntity> findAllEmployees();
}

