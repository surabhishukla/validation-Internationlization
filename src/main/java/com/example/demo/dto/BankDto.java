package com.example.demo.dto;

import com.example.demo.entity.Bank;
import com.example.demo.entity.User;

import java.util.Set;

public class BankDto {

    private String bank_name;

    private String place;

    private String pin_code;

    private Set<User> users;

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public BankDto() {

    }

    public BankDto(String bank_name, String place, String pin_code, Set<User> users) {
        this.bank_name = bank_name;
        this.place = place;
        this.pin_code = pin_code;
        this.users = users;
    }

    public static BankDto generateFrom(Bank bank){

        BankDto bankDto= new BankDto();
        try {
            bankDto.setBank_name(bank.getBank_name());
            bankDto.setPlace(bank.getPlace());
            bankDto.setPin_code(bank.getPin_code());
            bankDto.setUsers(bank.getUsers());
        }catch (Exception e){
            System.out.println("not found");
        }
        return bankDto;
    }

}
