package com.example.demo.request;

import com.example.demo.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class BankRequest {

    @NotBlank(message = "bank name should not be null")
    @Size(min = 1, max = 255, message = "size should not be greater than 255 and less than 1")
    @Pattern(regexp = "^[a-zA-Z]([a-zA-Z0-9 _-])*$", message = "Pattern not allowed")
    private String bank_name;

    @NotBlank(message = "place should not be null")
    @Size(min = 1, max = 255, message = "size should not be greater than 255 and less than 1")
    @Pattern(regexp = "^[a-zA-Z]([a-zA-Z0-9 _-])*$", message = "Pattern not allowed")
    private String place;

    @NotBlank(message = "pincode should not be null")
    @Size(min = 6, max = 8, message = "size should not be greater than 8 and less than 6")
    @Pattern(regexp = "^[+]?[() 0-9]$", message = "Pattern not allowed")
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
}
