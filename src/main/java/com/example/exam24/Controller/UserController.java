package com.example.exam24.Controller;

import com.example.exam24.Service.UserService;
import com.example.exam24.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
