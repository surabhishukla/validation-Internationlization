package com.example.demo.controller;

import com.example.demo.dto.PassbookDto;
import com.example.demo.exception.SpaceNotAllowed;
import com.example.demo.request.PassbookRequest;
import com.example.demo.service.PassbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/passbook")
public class PassbookController {

    @Autowired
    private PassbookService passbookService;

    @PostMapping()
    public void createPassbook (@Valid @RequestBody PassbookRequest passbookRequest){
        passbookService.savePassbook(passbookRequest);
    }

    @GetMapping()
    public void getAllPassbook(){
        passbookService.getAllPassbook();
    }

    @GetMapping("/{passbook_id}")
    public PassbookDto getPassbookById(@PathVariable String passbook_id){
        if (passbook_id.contains(" ")) throw new SpaceNotAllowed();
        return passbookService.getPassbookById(passbook_id);
    }

    @PutMapping("/{passbook_id}")
    public void updatePassbookById(@PathVariable String passbook_id, @RequestBody PassbookRequest passbookRequest){
        if (passbook_id.contains(" ")) throw new SpaceNotAllowed();
        passbookService.updatePassbook(passbook_id,passbookRequest);
    }

    @DeleteMapping("/{passbook_id}")
    public void deletePassbook(@PathVariable String passbook_id){
        if (passbook_id.contains(" ")) throw new SpaceNotAllowed();
        passbookService.deletePassbook(passbook_id);
    }

    @GetMapping("/branch/{branch}")
    public List<Long> getAccountBranch(@PathVariable String branch){
        return  passbookService.getAccountByBranch(branch);
    }

}


