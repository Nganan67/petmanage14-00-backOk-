package org.example.petmanage1.service;

import org.example.petmanage1.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    User selectUserByUserId(Long userId);
    User userSave(User user);
    User userEdit(Long userId, User updatedUser);
    void userDelete(Long userId);
}