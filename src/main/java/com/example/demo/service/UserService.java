package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(UserRequest userRequest){

        User user= new User();
        user.setUser_name(userRequest.getUser_name());
        user.setUser_f_name(userRequest.getUser_f_name());
        user.setAddress(userRequest.getAddress());
        user.setBanks(userRequest.getBanks());
        userDao.addUsers(user);
    }

    public UserDto getUserById(String user_id){
        User user= userDao.getUserById(user_id);
        return UserDto.generateFrom(user);
    }

    public List<User> getUser(){
       return userDao.getAllUSer();
    }

    public void deleteUser(String user_id){
        userDao.deleteUSer(user_id);
    }

    public void updateUser(String user_id,UserRequest userRequest){
        User user= new User();
        user.setUser_id(user_id);
        user.setUser_name(userRequest.getUser_name());
        user.setUser_f_name(userRequest.getUser_f_name());
        user.setAddress(userRequest.getAddress());
        user.setBanks(userRequest.getBanks());
        user.setAccounts(userRequest.getAccounts());
        userDao.updateUserId(user);
    }
}
