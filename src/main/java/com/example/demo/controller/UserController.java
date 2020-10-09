package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.SpaceNotAllowed;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public void createUser (@Valid @RequestBody UserRequest userRequest){
        userService.saveUser(userRequest);
    }

    @GetMapping
    public void getAllUser(){
        userService.getUser();
    }

    @GetMapping("/{user_id}")
    public UserDto getUserById(@PathVariable String user_id){
        if (user_id.contains(" ")) throw new SpaceNotAllowed();
        return userService.getUserById(user_id);
    }

    @PutMapping("/{user_id}")
    public void updateUserById(@PathVariable String user_id, @RequestBody UserRequest userRequest){
        if (user_id.contains(" ")) throw new SpaceNotAllowed();
        userService.updateUser(user_id,userRequest);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable String user_id){
        if (user_id.contains(" ")) throw new SpaceNotAllowed();
        userService.deleteUser(user_id);
    }
}
