package com.example.demo;



import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repos.RoleRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(Objects.isNull(userRepo.findByEmail("doug@bailey.com"))) {
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            Role savedRole = roleRepo.save(role);

            Set<Role> roles = new HashSet<>();
            roles.add(savedRole);

            User user = new User();
            user.setFirstName("doug");
            user.setLastName("bailey");
            user.setEmail("doug@bailey.com");
            user.setPassword(passwordEncoder.encode("doug"));


            //SET FIRSTNAME AND LASTNAME USING SETTER
            user.setRoles(roles);
            userRepo.save(user);
        }
        if(Objects.isNull(userRepo.findByEmail("john@ferguson.com"))) {
            Role role = new Role();
            role.setName("ROLE_USER");
            Role savedRole = roleRepo.save(role);

            Set<Role> roles = new HashSet<>();
            roles.add(savedRole);

            User user = new User();
            user.setFirstName("john");
            user.setLastName("ferguson");
            user.setEmail("john@ferguson.com");
            user.setPassword(passwordEncoder.encode("john"));


            //SET FIRSTNAME AND LASTNAME USING SETTER
            user.setRoles(roles);
            userRepo.save(user);
        }
    }
}
