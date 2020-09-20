package com.example.infotraining.controller;
/*
 * @author: Vu Ngoc Sang
 * @Date: 19/09/2020
 * @Role: Intern
 */

import com.example.infotraining.entity.Transaction;
import com.example.infotraining.entity.TransferMoney;
import com.example.infotraining.service.BankTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankTransferController {
    @Autowired
    BankTransferService transferService;

    @RequestMapping(value = "bank/transfermoney",method = RequestMethod.PUT,
            consumes = "application/json")
    public HttpStatus transferMoney(@RequestBody TransferMoney transferMoney){
        if (transferService.processTransferMoney(transferMoney)){
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "bank/gettransaction", method = RequestMethod.GET,
            produces = "application/json")
    public Iterable<Transaction> getTransaction(){
        return transferService.findAllTransaction();
    }
}
