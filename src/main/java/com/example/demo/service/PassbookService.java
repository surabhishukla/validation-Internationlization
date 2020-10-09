package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import com.example.demo.dao.PassbookDao;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.PassbookDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Passbook;
import com.example.demo.request.AccountRequest;
import com.example.demo.request.PassbookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassbookService {

    @Autowired
    private PassbookDao passbookDao;

    public void savePassbook(PassbookRequest passbookRequest){

        Passbook passbook= new Passbook();
        passbook.setIfsc_code(passbookRequest.getIFSC_code());
        passbook.setBranch(passbookRequest.getBranch());
        passbook.setAccount(passbookRequest.getAccount());
        passbookDao.addPassbook(passbook);
    }

    public PassbookDto getPassbookById(String passbook_id){
        Passbook passbook= passbookDao.getPassbookById(passbook_id);
        return PassbookDto.generateFrom(passbook);
    }

    public List<Passbook> getAllPassbook(){
        return passbookDao.getAllPassbook();
    }

    public void deletePassbook(String passbook_id){
        passbookDao.deletePassbook(passbook_id);
    }

    public void updatePassbook(String passbook_id, PassbookRequest passbookRequest){
        Passbook passbook= new Passbook();
        passbook.setPassbook_id(passbook_id);
        passbook.setIfsc_code(passbookRequest.getIFSC_code());
        passbook.setAccount(passbookRequest.getAccount());
        passbook.setBranch(passbookRequest.getBranch());
        passbookDao.updatePassbook(passbook);
    }

    public List<Long> getAccountByBranch(String branch){
        return passbookDao.getAccountForBranch(branch);
    }

}
