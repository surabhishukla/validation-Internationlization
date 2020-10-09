package com.example.demo.dto;

import com.example.demo.entity.Bank;
import com.example.demo.entity.User;

import java.util.Set;

public class UserDto {

    private String user_name;

    private String user_f_name;

    private String address;

    private Set<Bank> banks;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_f_name() {
        return user_f_name;
    }

    public void setUser_f_name(String user_f_name) {
        this.user_f_name = user_f_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

    public UserDto() {

    }

    public UserDto(String user_name, String user_f_name, String address, Set<Bank> banks) {
        this.user_name = user_name;
        this.user_f_name = user_f_name;
        this.address = address;
        this.banks = banks;
    }

    public static UserDto generateFrom(User user){

        UserDto userDto= new UserDto();
        try {
            userDto.setUser_name(user.getUser_name());
            userDto.setUser_f_name(user.getUser_f_name());
            userDto.setAddress(user.getAddress());
            userDto.setBanks(user.getBanks());
        }catch (Exception e){
            System.out.println("not found");
        }
        return userDto;
    }
}
