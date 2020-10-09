package com.example.demo.controller;


import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.exception.SpaceNotAllowed;
import com.example.demo.request.AccountRequest;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping()
    public void createAccount (@Valid @RequestBody AccountRequest accountRequest){
        accountService.saveAccount(accountRequest);
    }

    @GetMapping()
    public List<Account> getAllAccount(){
      return  accountService.getAccount();
    }

    @GetMapping("/{account_no}")
    public AccountDto getAccountById(@PathVariable String account_no){
        if (account_no.contains(" ")) throw new SpaceNotAllowed();
        return accountService.getAccountById(account_no);
//        if (account_no.startsWith("@"))
//            return messageSource.getMessage("Space.not.allowed", null, locale);
    }

    @PutMapping("/{account_no}")
    public void updateAcountById(@PathVariable String account_no, @RequestBody AccountRequest accountRequest){
        if (account_no.contains(" ")) throw new SpaceNotAllowed();
        accountService.updateAccount(account_no,accountRequest);
    }

    @DeleteMapping("/{account_no}")
    public void deleteAccount(@PathVariable String account_no){
        if (account_no.contains(" ")) throw new SpaceNotAllowed();
        accountService.deleteAccount(account_no);
    }

    @GetMapping("/avg/{account_type}")
    public List<Double> getAvgBalance(@PathVariable String account_type) throws Exception {
        if (account_type.contains(" ")) throw new SpaceNotAllowed();
      return  accountService.getAvgBalance(account_type);
    }

    @GetMapping("/date/{first_date}/{second_date}")
    public List<String> getAccountDate(@PathVariable String first_date, @PathVariable String second_date,
                                       @RequestHeader(name="Accept-Language", required=false) Locale locale) throws Exception {
        if (first_date.startsWith("@"))
            return Collections.singletonList(messageSource.getMessage("Specificword.not.allowed", null, locale));
       return accountService.getAccountDate(first_date,second_date);
    }

    @GetMapping("/passbook/{passbook_id}")
    public List<Account> getBalancePassbook(@PathVariable String passbook_id) throws Exception {
        return accountService.getBalanceByPassbook(passbook_id);
    }

    @GetMapping("/accounttype")
    public List<Account> getAccountByType() throws Exception {
        return accountService.getAccuntByType();
    }
}
