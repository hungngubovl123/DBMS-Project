package com.ute.dbms.bkwebshop.controller;

import javax.validation.constraints.Null;

import com.ute.dbms.bkwebshop.entity.User;
import com.ute.dbms.bkwebshop.repository.UserRepository;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private PasswordEncoder passwordEncoder;
    @GetMapping(value = "/")
    public String repuestMenthondName() {
        return "Wellcome project dbms nhom 9";
    }
    @GetMapping(value = "/user/")         
    public ResponseEntity<Iterable<User>> getAllUEntity() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/login")         
    public Long requestMethodName() {
        User user = userRepository.findByEmail("admin@gmail.com");
        System.out.println(user.getEmail());
        System.out.println(passwordEncoder.upgradeEncoding(user.getPassword()));
        return user.getId();
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User other = userRepository.findByEmail(user.getEmail());
        System.out.println(user.getEmail());
        if (null == other || !new BCryptPasswordEncoder().matches(user.getPassword(), other.getPassword())) {
            System.out.println("login false");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
        }
        
        return ResponseEntity.ok("login true");
    }
}
