package com.example.demo.controller;

import com.example.demo.dto.BankDto;
import com.example.demo.exception.SpaceNotAllowed;
import com.example.demo.request.BankRequest;
import com.example.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping()
    public void createBank (@Valid @RequestBody BankRequest bankRequest){
        bankService.addBank(bankRequest);
    }

    @GetMapping()
    public void getAllBank(){
        bankService.getBank();
    }

    @GetMapping("/{bank_id}")
    public BankDto getBankById(@PathVariable String bank_id){
        if (bank_id.contains(" ")) throw new SpaceNotAllowed();
        return bankService.getBankById(bank_id);
    }

    @PutMapping("/{bank_id}")
    public void updateBankById(@PathVariable String bank_id, @RequestBody BankRequest bankRequest){
        if (bank_id.contains(" ")) throw new SpaceNotAllowed();
        bankService.updateBank(bank_id,bankRequest);
    }

    @DeleteMapping("/{bank_id}")
    public void deleteBank(@PathVariable String bank_id){
        if (bank_id.contains(" ")) throw new SpaceNotAllowed();
        bankService.deleteBank(bank_id);
    }
}
