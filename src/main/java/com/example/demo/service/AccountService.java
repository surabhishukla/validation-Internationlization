package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void saveAccount(AccountRequest accountRequest){

        Account account= new Account();
        account.setAccount_type(accountRequest.getAccount_type());
        account.setBalance(accountRequest.getBalance());
        account.setOpening_date(accountRequest.getOpening_date());
        account.setUser_id(accountRequest.getUser_id());
        account.setPassbook(accountRequest.getPassbook());
        accountDao.addAccount(account);
    }

    public AccountDto getAccountById(String account_no){
        Account account= accountDao.getAccountById(account_no);
        return AccountDto.generateFrom(account);
    }

    public List<Account> getAccount(){
        return accountDao.getAllAccount();
    }

    public void deleteAccount(String account_no){
        accountDao.deleteAccount(account_no);
    }

    public void updateAccount(String account_no,AccountRequest accountRequest){
        accountDao.updateAccount(account_no,accountRequest);
    }

    public List<Double> getAvgBalance(String account_type) throws Exception {
      return accountDao.getAvgBalance(account_type);
    }

    public List<String> getAccountDate(String first_date, String second_date) throws Exception {
        List<String> accountList= (List<String>) accountDao.getAccountBetweenDate(first_date,second_date);
        return AccountDto.AccountBtwDate(accountList);
    }

    public List<Account> getBalanceByPassbook(String passbook_id) throws Exception {
        return accountDao.getBalanceByPassbook(passbook_id);
    }

    public List<Account> getAccuntByType() throws Exception {
        return accountDao.getAccountByType();
    }

}
