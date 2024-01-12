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
        // Skab ny brugerinstans
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Gemmer Brugeren
        return userRepository.save(user);
    }
}
