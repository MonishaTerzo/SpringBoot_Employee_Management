package com.example.asses.demo.EmployeeService.impl;
import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.EmployeeDto.RegistrationDto;
import com.example.asses.demo.EmployeeRepository.RoleRepository;
import com.example.asses.demo.EmployeeRepository.UserRepository;
import com.example.asses.demo.EmployeeService.UserService;
import com.example.asses.demo.model.Employee;
import com.example.asses.demo.model.Role;
import com.example.asses.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword((registrationDto.getPassword()));
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity findByRole(String username) {
        return null;
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<UserEntity> findAllEmployees() {
        List<UserEntity> user = userRepository.findAll();
        return user;
    }
}