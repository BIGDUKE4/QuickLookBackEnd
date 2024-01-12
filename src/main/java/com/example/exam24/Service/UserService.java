package com.example.exam24.Service;

import com.example.exam24.Model.User;
import com.example.exam24.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String password) {
        // Create a new user instance
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Save the user in the database
        return userRepository.save(user);
    }
}
