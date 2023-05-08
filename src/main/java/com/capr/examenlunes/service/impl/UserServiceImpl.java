package com.capr.examenlunes.service.impl;

import com.capr.examenlunes.dto.UserDTO;
import com.capr.examenlunes.model.User;
import com.capr.examenlunes.repository.UserRepository;
import com.capr.examenlunes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getUserById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return user;
    }

    @Override
    public User createdUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }
}
