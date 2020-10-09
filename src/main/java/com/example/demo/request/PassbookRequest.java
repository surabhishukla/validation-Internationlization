package com.example.demo.request;

import com.example.demo.entity.Account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PassbookRequest {

    @NotBlank(message = "branch should not be null")
    @Size(min = 1, max = 255, message = "size should not be greater than 255 and less than 1")
    @Pattern(regexp = "^[a-zA-Z]([a-zA-Z0-9 _-])*$", message = "Pattern not allowed")
    private String branch;

    @NotBlank(message = "IFSC_code should not be null")
    @Size(min = 1, max = 255, message = "size should not be greater than 255 and less than 1")
    @Pattern(regexp = "^[a-zA-Z]([a-zA-Z0-9 _-])*$", message = "Pattern not allowed")
    private String IFSC_code;

    private Account account;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIFSC_code() {
        return IFSC_code;
    }

    public void setIFSC_code(String IFSC_code) {
        this.IFSC_code = IFSC_code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
