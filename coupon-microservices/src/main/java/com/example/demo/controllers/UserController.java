package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.repos.UserRepo;
import com.example.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/showReg")
    public String showRegistrationPage(){
        return "registerUser";
    }
    @PostMapping("/registerUser")
    public String register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }
    @GetMapping("/")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password){
        System.out.println("HELOOOOO");
        boolean loginResponse = securityService.login(email, password);
        if(loginResponse){
            return "index";
        }
        return "login";
    }
    @GetMapping("/heyy")
    @ResponseBody
    public String respone(){
        return "TESTING";
    }
}
