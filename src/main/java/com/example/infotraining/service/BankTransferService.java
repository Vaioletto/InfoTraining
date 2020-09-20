package com.example.infotraining.service;
/*
 * @author: Vu Ngoc Sang
 * @Date: 19/09/2020
 * @Role: Intern
 */
import com.example.infotraining.entity.Message;
import com.example.infotraining.entity.Transaction;
import com.example.infotraining.entity.TransferMoney;
import com.example.infotraining.repo.MessageRepo;
import com.example.infotraining.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BankTransferService {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private TransactionRepo transactionRepo;

    public boolean isEmpty(Transaction transaction){
        return transaction.getAmount() == 0.0 && transaction.getCurrency() == null
                && transaction.getSender_acct() == null && transaction.getReceiver_acct() == null
                && transaction.getTransaction_id() == null;
    }

    public Boolean processTransferMoney(TransferMoney transferMoney){
        Message message = new Message();
        message.setMessage_name(transferMoney.getMessage_name());
        message.setMessage_type(transferMoney.getMessage_type());
        // get datetime of money transfer request
        Date date= new Date();
        message.setCreateDate(date);
        Message getSaveMessage = messageRepo.save(message);

        List<Transaction> transactions = transferMoney.getTransaction();
        // check if transaction json is empty
        if (!transactions.isEmpty()){
            for (Transaction transaction: transactions){
                if (transactionRepo.findById(transaction.getTransaction_id()).isEmpty()){
                    transaction.setMessage_id(getSaveMessage.getMessage_id());
                    transactionRepo.save(transaction);
                }
            }
        }else return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public Iterable<Transaction> findAllTransaction(){
        return transactionRepo.findAll();
    }

}
