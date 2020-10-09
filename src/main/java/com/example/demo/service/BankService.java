package com.example.demo.service;

import com.example.demo.dao.BankDao;
import com.example.demo.dto.BankDto;
import com.example.demo.entity.Bank;
import com.example.demo.request.BankRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankDao bankDao;

    public void addBank(BankRequest bankRequest){

        Bank bank= new Bank();
        bank.setBank_name(bankRequest.getBank_name());
        bank.setPin_code(bankRequest.getPin_code());
        bank.setPlace(bankRequest.getPlace());
        bank.setUsers(bankRequest.getUsers());
        bankDao.addBank(bank);
    }

    public BankDto getBankById(String bank_id){

        Bank bank= bankDao.getBankById(bank_id);
        return BankDto.generateFrom(bank);
    }

    public List<Bank> getBank(){
        return bankDao.getAllBank();
    }

    public void updateBank(String bank_id, BankRequest bankRequest){
        Bank bank= new Bank();
        bank.setBank_id(bank_id);
        bank.setBank_name(bankRequest.getBank_name());
        bank.setPlace(bankRequest.getPlace());
        bank.setPin_code(bankRequest.getPin_code());
        bank.setUsers(bankRequest.getUsers());
        bankDao.updateBank(bank);
    }

    public void deleteBank(String user_id){
        bankDao.deleteBank(user_id);
    }
}
