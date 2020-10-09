package com.example.demo.dto;

import com.example.demo.entity.Account;
import com.example.demo.entity.Passbook;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDto {

    private String account_no;

    private String account_type;

    private Date opening_date;

    private double balance;

    private User user_id;

    private Passbook passbook;

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(Date opening_date) {
        this.opening_date = opening_date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Passbook getPassbook() {
        return passbook;
    }

    public void setPassbook(Passbook passbook) {
        this.passbook = passbook;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public AccountDto() {

    }

    public AccountDto(String account_type, Date opening_date, double balance, User user_id, Passbook passbook) {
        this.account_no= account_no;
        this.account_type = account_type;
        this.opening_date = opening_date;
        this.balance = balance;
        this.user_id = user_id;
        this.passbook = passbook;
    }

    public static AccountDto generateFrom(Account account){

        AccountDto accountDto= new AccountDto();
        try {
            accountDto.setAccount_type(account.getAccount_type());
            accountDto.setBalance(account.getBalance());
            accountDto.setOpening_date(account.getOpening_date());
            accountDto.setPassbook(account.getPassbook());
            accountDto.setUser_id(account.getUser_id());
        }catch (Exception e){
            System.out.println("not found");
        }
        return accountDto;
    }

//    public static AccountDto AccountBtwDate(List<String> accountList){
//
//        AccountDto accountDto= new AccountDto();
//       /// List<String> accountDto= new ArrayList<>();
//        try {
//           // for (String accountList1:accountList)
//            for (int i=0; i<accountList.size();i++)
//            accountDto.setAccount_no(accountList.get(i));
//        }catch (Exception e){
//            System.out.println("not found");
//        }
//        return accountDto;
//    }

    public static List<String> AccountBtwDate(List<String> accountList){

        AccountDto accountDto= new AccountDto();
        List<String> s= new ArrayList<>();
        try {
            for (int i=0; i<accountList.size();i++) {
                accountDto.setAccount_no(accountList.get(i));
                s.add(String.valueOf(accountDto.account_no));
            }
        }catch (Exception e){
            System.out.println("not found");
        }
        return s;
    }

    public static List<Double> getAvgBalance(List<Double> accountList){

        AccountDto accountDto= new AccountDto();
        List<Double> s= new ArrayList<>();
        try {
            for (int i=0; i<accountList.size();i++) {
                accountDto.setBalance(accountList.get(i));
                s.add(Double.valueOf(accountDto.account_no));
            }
        }catch (Exception e){
            System.out.println("not found");
        }
        return s;
    }

    public static List<Account> getBalanceByPassbook(List<Account> accountList){
        List<Account> s= new ArrayList<>();
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
