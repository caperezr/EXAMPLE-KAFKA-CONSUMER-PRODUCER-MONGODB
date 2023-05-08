package com.capr.examenlunes.service;

import com.capr.examenlunes.dto.UserDTO;
import com.capr.examenlunes.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(String id);
    User createdUser(UserDTO userDTO);
}
