package org.example.petmanage1.service.Impl;

import org.example.petmanage1.entity.Admin;
import org.example.petmanage1.entity.User;
import org.example.petmanage1.repository.AdminRepository;
import org.example.petmanage1.repository.UserRepository;
import org.example.petmanage1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //返回全部用户列表getUserList()
    @Override
    public List<User> getUserList(){
        return userRepository.findAll();
    }
    //通过用户ID选择用户selectUserById()
    @Override
    public User selectUserByUserId(Long userId){
        return userRepository.findUserByUserId(userId).orElse(null);
    }
    //保存用户UserSave()
    @Override
    public User userSave(User user) {
        return userRepository.save(user);
    }
    //更新用户UserEdit()
    @Override
    public User userEdit(Long userId, User updatedUser){
        User user = userRepository.findUserByUserId(userId).orElse(null);
        if(user != null){
            //更新属性
            user.setUserName(updatedUser.getUserName());
            user.setUserPassword(updatedUser.getUserPassword());
            return userRepository.save(user);
        }
        return null;
    }
    //删除用户UserDelete()
    @Override
    public void userDelete(Long userId) {
        userRepository.deleteUserByUserId(userId);
    }
    //获取用户getUserList()
}
