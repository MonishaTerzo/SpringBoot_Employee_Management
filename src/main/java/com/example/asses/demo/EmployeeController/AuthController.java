package com.example.asses.demo.EmployeeController;

import com.example.asses.demo.EmployeeDto.RegistrationDto;
import com.example.asses.demo.EmployeeService.UserService;
import com.example.asses.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public List<UserEntity> Userdetails(){
        List<UserEntity> E=userService.findAllEmployees();
        return E;
    }

    @PostMapping("/register")
    public void userRegistration(@RequestBody RegistrationDto user){

        userService.saveUser(user);
    }


    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam long username){
        userService.delete(username);
    }

}