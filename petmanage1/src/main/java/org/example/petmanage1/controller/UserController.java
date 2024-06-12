package org.example.petmanage1.controller;

import org.example.petmanage1.entity.User;
import org.example.petmanage1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //支持分页显示user列表请求
    //getUserList()全部管理员请求
    @GetMapping("{id}")
    public User findUserByUserId(@PathVariable Long userId) {
        return userService.selectUserByUserId(userId);
    }
    //addUser()实现添加用户请求
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.userSave(user);
    }
    //editUser()实现编辑更新用户信息
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.userEdit(userId,user);
    }
    //deleteUser()实现删除用户信息
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long userId){
        userService.userDelete(userId);
    }
}
