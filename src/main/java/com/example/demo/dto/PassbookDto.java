package com.example.demo.dto;

import com.example.demo.entity.Account;
import com.example.demo.entity.Passbook;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class PassbookDto {

    private String branch;

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

    public PassbookDto() {

    }

    public PassbookDto(String branch, String IFSC_code, Account account) {
        this.branch = branch;
        this.IFSC_code = IFSC_code;
        this.account = account;
    }

    public static PassbookDto generateFrom(Passbook passbook){

        PassbookDto passbookDto= new PassbookDto();
        try {
            passbookDto.setIFSC_code(passbook.getIfsc_code());
            passbookDto.setAccount(passbook.getAccount());
            passbookDto.setBranch(passbook.getBranch());
        }catch (Exception e){
            System.out.println("not found");
        }
        return passbookDto;
    }

    public static List<Long> getAccountForBranch(List<Long> accountList){
        List<Long> s= new ArrayList<>();
        try {
            for (int i=0; i<accountList.size();i++) {
                s.add(accountList.get(i));
            }
        }catch (Exception e){
            System.out.println("not found");
        }
        return s;
    }
}
