package com.Book.GoCab.Controller;

import com.Book.GoCab.Model.User;
import com.Book.GoCab.Repository.UserRepository;
import com.Book.GoCab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
